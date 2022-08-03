package nossaCasa.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nossaCasa.com.models.ItensComodo;
import nossaCasa.com.repositories.ItensComodoRepository;

@Service
public class ItensComodoService {

	@Autowired
	private ItensComodoRepository itensComodoRepository;
	
	public List<ItensComodo> buscarTodosItens() { 
		return itensComodoRepository.findAll();
	}
	
	public List<ItensComodo> buscarItens(String comodoNome) {
		return itensComodoRepository.findByComodoNome(comodoNome);
	}
	
	public ItensComodo salvarItensComodo(ItensComodo itensComodo) {
		return itensComodoRepository.save(itensComodo);
	}
	
}
