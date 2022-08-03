package nossaCasa.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nossaCasa.com.models.Comodo;

@Repository
public interface ComodoRepository extends JpaRepository<Comodo, Integer>{

}
