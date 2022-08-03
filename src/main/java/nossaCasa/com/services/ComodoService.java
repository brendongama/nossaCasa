package nossaCasa.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nossaCasa.com.models.Comodo;
import nossaCasa.com.repositories.ComodoRepository;

@Service
public class ComodoService {

	@Autowired
	private ComodoRepository comodoRepository;
	
	public List<Comodo> buscarTodosComodos() {
		return comodoRepository.findAll();
	}
	
	public Optional<Comodo> buscarUmComodo(Integer id) {			
		return comodoRepository.findById(id);
	}
	
	public Comodo salvarComodo(Comodo comodo) {
		return comodoRepository.save(comodo);
	}
	
}
