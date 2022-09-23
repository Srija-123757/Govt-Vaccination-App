package project.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import project.springboot.model.Govtvaccinehd;

@Repository
public interface GovtVaccineHDRepository extends JpaRepository<Govtvaccinehd,Long>{

}
