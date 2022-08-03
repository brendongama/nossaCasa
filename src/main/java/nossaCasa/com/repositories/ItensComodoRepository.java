package nossaCasa.com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nossaCasa.com.models.ItensComodo;

@Repository
public interface ItensComodoRepository extends JpaRepository<ItensComodo, Integer>{

	List<ItensComodo> findByComodoNome(String comodoNome);

}
 