package dev.top.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@CrossOrigin
@RestController()
@RequestMapping("/")
public class CollegueCtrl {
	@Autowired
	private CollegueRepo collegueRepo;

	@GetMapping("collegues")
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
	}

	@GetMapping("collegues/{pseudo}")
	public Collegue find(@PathVariable String pseudo) {
		return this.collegueRepo.findByPseudo(pseudo);
	}

	@PatchMapping("collegues/{pseudo}")
	public Collegue patch(@PathVariable String pseudo, @RequestBody Map<String, String> vote) {
		final Collegue collegue = collegueRepo.findByPseudo(pseudo);

		collegue.setScore(collegue.getScore() + (vote.get("action").equals("AIMER") ? 10 : -5));
		collegueRepo.save(collegue);

		return collegue;
	}

	@PostMapping("/collegues")
	public ResponseEntity<?> exists(@RequestBody Map<String, String> infos) {
		RestTemplate rt = new RestTemplate();
		Collegue[] collegue = rt.getForObject("http://collegues-api.cleverapps.io/collegues?matricule=" + infos.get("matricule"), Collegue[].class);

		if (collegue.length > 0) {
			String photo = infos.get("photo").equals("") ? collegue[0].getPhoto() : infos.get("photo");
			collegueRepo.save(new Collegue(collegue[0].getNom(), collegue[0].getPrenom(), infos.get("pseudo"),
					collegue[0].getEmail(), collegue[0].getAdresse(), 0, photo));
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
