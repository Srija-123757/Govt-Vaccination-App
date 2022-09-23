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
import project.springboot.model.Questions1;
import project.springboot.repository.Question1Repository;


@RestController
@CrossOrigin(origins="http://localhost:62062/")
@RequestMapping()

public class Question1Controller {
	@Autowired
	private Question1Repository question1Repository;
	
	
	//get all questions
	 @GetMapping("/questions1")
	 public List<Questions1> getAllQuestions1(){
		 return question1Repository.findAll();
	 }
	//create question rest api
	 @PostMapping("/questions1")
	 public Questions1 createQuestion1(@RequestBody Questions1 question) {
		 
		 return question1Repository.save(question);
	
	 }
	 //get employee by id rest api
	 
	 @GetMapping("/questions1/{id}")
	 public ResponseEntity<Questions1> getQuestions1ById(@PathVariable Long id){
		 Questions1 questions=question1Repository.findById(id).
					orElseThrow(()-> new ResourceNotFoundException("Question not exist with id:"+id));
		 
		 return ResponseEntity.ok(questions);
	 }
	 
	 //update question rest api
	 
	   @PutMapping("/questions1/{id}")
	  public  ResponseEntity<Questions1> updateQuestions1(@PathVariable Long id,@RequestBody Questions1 questionsDeails){
		 Questions1 questions = question1Repository.findById(id).
					orElseThrow(()-> new ResourceNotFoundException("Question not exist with id:"+id));
	 
	 questions.setQuestion1(questionsDeails.getQuestion1());
	 questions.setAnswer1(questionsDeails.getAnswer1());
	 
	    Questions1 updatedQuestions1=question1Repository.save(questions);
	    return ResponseEntity.ok(updatedQuestions1);
	    
	 }
	 //delete questions rest api
	   @DeleteMapping("/questions1/{id}")
	   public ResponseEntity<Map<String,Boolean>>deleteQuestion(@PathVariable Long id){
		   Questions1 questions = question1Repository.findById(id).
					orElseThrow(()-> new ResourceNotFoundException("Question not exist with id:"+id));
	   
	             question1Repository.delete(questions);
	             Map<String,Boolean> response=new HashMap<>();
	             response.put("deleted", Boolean.TRUE);
	             return ResponseEntity.ok(response);  
	   }
	   
	   
}