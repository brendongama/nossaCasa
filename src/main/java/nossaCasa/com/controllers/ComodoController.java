package nossaCasa.com.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import nossaCasa.com.models.Comodo;
import nossaCasa.com.services.ComodoService;

@RestController
@RequestMapping("/comodo")
@Api(value = "API REST comodos")
@CrossOrigin(origins = "*")
public class ComodoController {
	
	@Autowired
	private ComodoService comodoservice;


	@GetMapping("")
	@ApiOperation(value = "Busca todos os comodos da casa")
	public ResponseEntity<List<Comodo>> buscarTodosOsComodos() {		
		List<Comodo> comodos = comodoservice.buscarTodosComodos();		
		return ResponseEntity.ok().body(comodos);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca somente um comodo da casa")
	public ResponseEntity<Comodo> buscarUmComodo(@PathVariable Integer id) {		 
		Optional<Comodo> comodo = comodoservice.buscarUmComodo(id);	
		if(comodo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(comodo.get());
	}
	 
	@PostMapping
	@ApiOperation(value = "Salva um comodo na casa")
	public ResponseEntity<Comodo> salvarComodo(@RequestBody Comodo comodo) {
		Comodo novoComodo = comodoservice.salvarComodo(comodo);
		return ResponseEntity.ok().body(novoComodo); 
		
	}

}
