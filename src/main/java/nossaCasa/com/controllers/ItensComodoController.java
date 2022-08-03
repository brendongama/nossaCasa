package nossaCasa.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nossaCasa.com.models.ItensComodo;
import nossaCasa.com.services.ItensComodoService;

@RestController
@RequestMapping("/itenscomodo")
@Api(value = "API REST itens do comodo")
@CrossOrigin(origins = "*")
public class ItensComodoController {
	
	@Autowired
	private ItensComodoService itensComodoService; 


	@ApiOperation(value = "Busca todos os itens com os comodos")
	@GetMapping("")
	public ResponseEntity<List<ItensComodo>> buscarTodosItens() {		
		List<ItensComodo> itensComodos = itensComodoService.buscarTodosItens();		
		return ResponseEntity.ok().body(itensComodos);
	}
	
	@GetMapping("/{comodoNome}")
	@ApiOperation(value = "Busca um comodo especifico com seus itens")
	public ResponseEntity<List<ItensComodo>> buscarPorComodoNome(@PathVariable String comodoNome) {		
		List<ItensComodo> itensComodos = itensComodoService.buscarItens(comodoNome);		
		return ResponseEntity.ok().body(itensComodos); 
	}

	 
	@PostMapping
	@ApiOperation(value = "Cadastra um item no seu devido comodo")
	public ResponseEntity<ItensComodo> salvarItensComodo(@RequestBody ItensComodo itensComodo) {
		ItensComodo novoItensComodo = itensComodoService.salvarItensComodo(itensComodo);
		return ResponseEntity.ok().body(novoItensComodo); 
		
	}

}
