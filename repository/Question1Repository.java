package project.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.springboot.model.Questions1;



@Repository
public interface Question1Repository extends JpaRepository<Questions1,Long>{
	

}