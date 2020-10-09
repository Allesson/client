package br.com.allesson.client.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.allesson.client.service.ClientService;
import br.com.allesson.client.vo.ClientVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
//@RequestMapping("/api")
@RequestMapping("/")
@Api(value = "CLIENTE REST API")
@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping(value = "/{page}")
	@ApiOperation(value = "Retorna pagina com lista de clientes")
	public ResponseEntity<Page<ClientVO>> findByPage(@PathVariable int page){
		
		Page<ClientVO> obj = service.listClients(page-1);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "client-search")
	@ApiOperation(value = "Retorna cliente")
	public ResponseEntity<ClientVO> findByClient(@RequestParam String cpf){
		ClientVO clientVO = service.findByClient(cpf);
		return ResponseEntity.ok().body(clientVO);
	}
	
	@PostMapping
	public ResponseEntity<ClientVO> insert(@RequestBody ClientVO obj){
		service.insertClient(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getCpf()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
