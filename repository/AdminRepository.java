package project.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.springboot.model.User;

@Repository
public interface AdminRepository extends JpaRepository<User,Long> {


}
