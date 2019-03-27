package com.example.kolekcijeservis;

import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KolekcijeservisApplicationTests {

	@Autowired
	KnjigaRepository knjigaRepository;

	@Test
	public void contextLoads() {
		knjigaRepository.save(new Knjiga(1,"test","test", new Date(), 1, 1));

	}

}
