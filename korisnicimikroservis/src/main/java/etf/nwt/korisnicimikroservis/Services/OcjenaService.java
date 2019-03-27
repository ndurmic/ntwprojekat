package etf.nwt.korisnicimikroservis.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.nwt.korisnicimikroservis.Models.OcjenaModel;
import etf.nwt.korisnicimikroservis.Repositories.OcjenaRepository;
@Service
public class OcjenaService {
	

		@Autowired
		OcjenaRepository ocjenaRepositori;
		
		public Iterable<OcjenaModel> findAll() {
			return ocjenaRepositori.findAll();
		}
		
		public Optional<OcjenaModel> findById(int id) {
			return ocjenaRepositori.findById(id);
		}
		
		public String addOcjena(OcjenaModel k) {
			try {
				ocjenaRepositori.save(k);
			} catch (Exception e) {
				return e.toString();
			}
			return "Radi";
		}
	

}
