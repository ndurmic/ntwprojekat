package etf.nwt.knjigemikroservis;

import com.fasterxml.jackson.databind.ObjectMapper;
import etf.nwt.knjigemikroservis.amqpProducer.AutorSender;
import etf.nwt.knjigemikroservis.controller.AutorController;
import etf.nwt.knjigemikroservis.model.Autor;
import etf.nwt.knjigemikroservis.service.AutorService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
@WebMvcTest(value = AutorController.class, secure = false)
public class AutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutorService autorService;

    @MockBean
    private AutorSender autorSender;


    Optional<Autor> mockAutor = Optional.of(new Autor("Autor", "Autorovic", "10/01/1994", "Kratka biografija o zivotu autora"));
    Autor simpleMockAutor = new Autor("Autor", "Autorovic", "10/01/1994", "Kratka biografija o zivotu autora");

    List<Autor> mockListaAutora = Arrays.asList(
            new Autor("Autor", "Autorovic", "10/01/1994", "Kratka biografija o zivotu autora"),
            new Autor("Neko", "Autorovic", "10/01/1994", "Kratka biografija o zivotu autora"),
            new Autor("Autor", "Nekovic", "10/01/1994", "Kratka biografija o zivotu autora"),
            new Autor("Testni", "Autor", "10/01/1994", "Kratka biografija o zivotu autora")
    );

    String body = "{\"ime\":\"Autor\",\"prezime\":\"Autorovic\",\"datumRodjenja\":\"10/01/1994\",\"biografija\":\"Kratka biografija o zivotu autora\"}";


    @Test
    public void dajListuAutora() throws Exception {

        Mockito.when( autorService.listaSvihAutora()).thenReturn(mockListaAutora);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/autori").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"ime\":\"Autor\",\"prezime\":\"Autorovic\",\"datumRodjenja\":\"10/01/1994\",\"biografija\":\"Kratka biografija o zivotu autora\"},{\"ime\":\"Neko\",\"prezime\":\"Autorovic\",\"datumRodjenja\":\"10/01/1994\",\"biografija\":\"Kratka biografija o zivotu autora\"},{\"ime\":\"Autor\",\"prezime\":\"Nekovic\",\"datumRodjenja\":\"10/01/1994\",\"biografija\":\"Kratka biografija o zivotu autora\"},{\"ime\":\"Testni\",\"prezime\":\"Autor\",\"datumRodjenja\":\"10/01/1994\",\"biografija\":\"Kratka biografija o zivotu autora\"}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void dajAutora() throws Exception {

        Mockito.when( autorService.dajAutora(1)).thenReturn(mockAutor);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/autori/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"ime\":\"Autor\",\"prezime\":\"Autorovic\",\"datumRodjenja\":\"10/01/1994\",\"biografija\":\"Kratka biografija o zivotu autora\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void obrisiAutora() throws Exception {

        Mockito.when( autorService.obrisiAutora(1)).thenReturn("Autor uspješno obrisana");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/autori/1");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "Autor uspješno obrisana";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

   @Test
    public void dodajAutora() throws Exception {

        Mockito.when( autorService.dodajAutora(simpleMockAutor)).thenReturn(simpleMockAutor);

       /* RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/autori")
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(simpleMockAutor))
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON);*/

       // MvcResult result = mockMvc.perform(requestBuilder).andReturn();

       mockMvc.perform( MockMvcRequestBuilders
               .post("/autori")
               .content(asJsonString(simpleMockAutor))
               .contentType(MediaType.APPLICATION_JSON)
               .characterEncoding("utf-8")
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());

       //MockHttpServletResponse response = result.getResponse();

        String expected = "{\"ime\":\"Autor\",\"prezime\":\"Autorovic\",\"datumRodjenja\":\"10/01/1994\",\"biografija\":\"Kratka biografija o zivotu autora\"}";

        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);


    }

    @Test
    public void azurirajAutora() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .put("/autori/1")
                .content(asJsonString(simpleMockAutor))
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
