package etf.nwt.korisnicimikroservis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

import etf.nwt.korisnicimikroservis.Controllers.KorisnikController;
import etf.nwt.korisnicimikroservis.Models.KorisnikModel;
import etf.nwt.korisnicimikroservis.Rabbitmq.KorisnikMessageSender;
import etf.nwt.korisnicimikroservis.Services.KnjigaService;
import etf.nwt.korisnicimikroservis.Services.KorisnikService;
import etf.nwt.korisnicimikroservis.Services.OcjenaService;

import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

 
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(value = KorisnikController.class, secure = false)
//@ContextConfiguration(classes = KorisnikController.class)
public class KorisnikControllerTest {

	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private KorisnikService korisnikService;
    @MockBean
    private KorisnikMessageSender korisnikSender;
    @MockBean
    private OcjenaService ocjenaService;
    @MockBean
    private KnjigaService knjigaService;
	
    @Test
    public void contextLoads() {
    }
    
    @Test
    public void obrisiKorisnika() throws Exception{
    	Mockito.when( korisnikService.obrisiKorisnika(1)).thenReturn("Korisnik uspješno obrisan");
    	 
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/obrisikorisnika/1");
 
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
 
        System.out.println(result.getResponse());
        String expected = "Korisnik uspješno obrisan";
 
        assertEquals(expected, result.getResponse().getContentAsString());
    }

}
