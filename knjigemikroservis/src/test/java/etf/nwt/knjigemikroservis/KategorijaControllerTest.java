package etf.nwt.knjigemikroservis;

import com.fasterxml.jackson.databind.ObjectMapper;
import etf.nwt.knjigemikroservis.amqpProducer.KategorijaSender;
import etf.nwt.knjigemikroservis.controller.KategorijaController;
import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.service.KategorijaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = KategorijaController.class, secure = false)
public class KategorijaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KategorijaService kategorijaService;

    @MockBean
    private KategorijaSender kategorijaSender;


    Optional<Kategorija> mockKategorija = Optional.of(new Kategorija("Roman"));
    Kategorija simpleMockKategorija = new Kategorija("Roman");

    List<Kategorija> mockListaKategorija = Arrays.asList(
            new Kategorija("Roman"),
            new Kategorija("Basna"),
            new Kategorija("Krimi")
    );

    String body = "{\"naziv\":\"Roman\"}";


    @Test
    public void dajListuKategorija() throws Exception {

        Mockito.when( kategorijaService.listaSvihKategorija()).thenReturn(mockListaKategorija);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/kategorije").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"naziv\":\"Roman\"},{\"naziv\":\"Basna\"},{\"naziv\":\"Krimi\"}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void dajKategoriju() throws Exception {

        Mockito.when( kategorijaService.dajKategoriju(1)).thenReturn(mockKategorija);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/kategorije/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"naziv\":\"Roman\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void obrisiKategoriju() throws Exception {

        Mockito.when( kategorijaService.obrisiKategoriju(1)).thenReturn("Kategorija uspješno obrisana");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/kategorije/1");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "Kategorija uspješno obrisana";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void dodajKategoriju() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .post("/kategorije")
                .content(asJsonString(simpleMockKategorija))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void azurirajKategoriju() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .put("/kategorije/1")
                .content(asJsonString(simpleMockKategorija))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
