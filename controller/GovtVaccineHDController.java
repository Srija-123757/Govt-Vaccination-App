

	package project.springboot.controller;

	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;


import project.springboot.exception.ResourceNotFoundException;
	import project.springboot.model.Govtvaccinehd;
import project.springboot.repository.GovtVaccineHDRepository;

	@RestController
	@CrossOrigin(origins="http://localhost:62062/")

	@RequestMapping

	public class GovtVaccineHDController {
		
		@Autowired
		private GovtVaccineHDRepository govtvaccinehdRepository;
		
		
		//get all issues
		
		@GetMapping("/govthd")
		
		public List<Govtvaccinehd> getAllGovtvaccinehds(){
			return govtvaccinehdRepository.findAll();
		}
	     
		
		//create issue
		@PostMapping("/govthd")
		
		
		public Govtvaccinehd createGovtvaccinehd(@RequestBody Govtvaccinehd govtvaccinehd)
		{
			
			return govtvaccinehdRepository.save(govtvaccinehd);
		}
		
		//get issue by id
		
		@GetMapping("/govthd/{id}")
		public ResponseEntity<Govtvaccinehd> getGovtvaccinehdById(@PathVariable Long id){
			Govtvaccinehd govtvaccinehd=govtvaccinehdRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Issue not exist with id: "+id));
			return ResponseEntity.ok(govtvaccinehd) ;
		}
		
		//update issue
		
		@PutMapping("/govthd/{id}")
		
		
		public ResponseEntity<Govtvaccinehd> updateGovtvaccinehd(@PathVariable Long id,@RequestBody Govtvaccinehd govtvaccinehdDetails){
			Govtvaccinehd govtvaccinehd=govtvaccinehdRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Issue not exist with id: "+id));
			
			govtvaccinehd.setContactName(govtvaccinehdDetails.getContactName());
			govtvaccinehd.setContactState(govtvaccinehdDetails.getContactState());
			govtvaccinehd.setSubmittedIssues(govtvaccinehdDetails.getSubmittedIssues());
			
			Govtvaccinehd updatedGovtvaccinehd=govtvaccinehdRepository.save(govtvaccinehd);
			return ResponseEntity.ok(updatedGovtvaccinehd);
		}
		
		//delete issue
		@DeleteMapping("/govthd/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteGovtvaccinehd(@PathVariable Long id,@RequestBody Govtvaccinehd govtvaccinehdDetails){
			Govtvaccinehd govtvaccinehd=govtvaccinehdRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Issue not exist with id: "+id));
			
			govtvaccinehdRepository.delete(govtvaccinehd);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		
	}

