package etf.nwt.korisnicimikroservis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import etf.nwt.korisnicimikroservis.Services.KorisnikService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(value = KorisniciMikroservis.class, secure = false)
public class KorisniciMikroservisTest {

	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private KorisnikService korisnikService;
	
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
