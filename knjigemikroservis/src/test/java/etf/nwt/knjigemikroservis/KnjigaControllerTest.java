package etf.nwt.knjigemikroservis;

import com.fasterxml.jackson.databind.ObjectMapper;
import etf.nwt.knjigemikroservis.amqpProducer.KnjigaSender;
import etf.nwt.knjigemikroservis.controller.KnjigaController;
import etf.nwt.knjigemikroservis.model.Knjiga;

import etf.nwt.knjigemikroservis.service.KnjigaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
@WebMvcTest(value = KnjigaController.class, secure = false)
public class KnjigaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KnjigaService knjigaService;

    @MockBean
    private KnjigaSender knjigaSender;


    Optional<Knjiga> mockKnjiga = Optional.of(new Knjiga("Knjiga 1","Opis knjige 1 duzi od 20 karaktera","10/01/1994"));
    Knjiga simpleMockKnjiga = new Knjiga("Knjiga 1","Opis knjige 1 duzi od 20 karaktera","10/01/1994");

    List<Knjiga> mockListaKnjiga = Arrays.asList(
            new Knjiga("Knjiga 1","Opis knjige 1 duzi od 20 karaktera","10/01/1994"),
            new Knjiga("Knjiga 2","Opis knjige 1 duzi od 20 karaktera","10/01/1994")
    );

    @Test
    public void dajListuKnjiga() throws Exception {

        Mockito.when( knjigaService.listaSvihKnjiga()).thenReturn(mockListaKnjiga);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/knjige").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"naslov\":\"Knjiga 1\",\"opis\":\"Opis knjige 1 duzi od 20 karaktera\",\"datumIzdavanja\":\"10/01/1994\",\"listaKategorija\":null,\"listaAutora\":null},{\"naslov\":\"Knjiga 2\",\"opis\":\"Opis knjige 1 duzi od 20 karaktera\",\"datumIzdavanja\":\"10/01/1994\",\"listaKategorija\":null,\"listaAutora\":null}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void dajKnjigu() throws Exception {

        Mockito.when( knjigaService.dajKnjigu(1)).thenReturn(mockKnjiga);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/knjige/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"naslov\":\"Knjiga 1\",\"opis\":\"Opis knjige 1 duzi od 20 karaktera\",\"datumIzdavanja\":\"10/01/1994\",\"listaKategorija\":null,\"listaAutora\":null}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void obrisiKnjigu() throws Exception {

        Mockito.when( knjigaService.obrisiKnjigu(1)).thenReturn("Knjiga uspješno obrisana");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/knjige/1");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "Knjiga uspješno obrisana";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void dodajKnjigu() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .post("/knjige")
                .content(asJsonString(simpleMockKnjiga))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void azurirajKnjigu() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .put("/knjige/1")
                .content(asJsonString(simpleMockKnjiga))
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
