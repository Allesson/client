package br.com.allesson.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.allesson.client.exceptions.DatabaseException;
import br.com.allesson.client.exceptions.NotFoundException;
import br.com.allesson.client.repository.ClientRepository;
import br.com.allesson.client.vo.ClientVO;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	private final int SIZE = 6;
	
	public Page<ClientVO> listClients(int page){
		Page<ClientVO> pageClients;
		PageRequest pageable = PageRequest.of(page, SIZE, Sort.Direction.ASC,
                "cpf");
        pageClients = clientRepository.getListClients(pageable);
        
        return pageClients;
	}
	
	public ClientVO findByClient(String cpf) {
		ClientVO clientVO = clientRepository.findByCpf(cpf);
		if (clientVO == null) {
			throw new NotFoundException("Resource not found. CPF " + cpf);
		}
		return clientVO;
		
	}
	
	public void insertClient(ClientVO clientVO) {
		try {
		clientRepository.insertClient(clientVO.getCpf(),clientVO.getNome(),clientVO.getNomeReduzido(), 
				clientVO.getSexo(), clientVO.getEmail(), clientVO.getTelefone());
		}catch (Exception e) {
			String msg;
			if (clientRepository.findByCpf(clientVO.getCpf()) != null) {
				msg = "Client already exists in the database.";
			}else {
				msg = "Error when trying to insert.";
			}
			throw new DatabaseException(msg + " CPF: " + clientVO.getCpf());
		}
	}

}
