package br.com.allesson.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.allesson.client.repository.ClientRepository;
import br.com.allesson.client.vo.ClientVO;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	private final int SIZE = 5;
	
	public List<ClientVO> listClients(int page){
		Page<ClientVO> pageClients;
        Pageable pageable = PageRequest.of(page, SIZE);
        pageClients = clientRepository.getListClients(pageable);
        
        return pageClients.getContent();
	}
	
	public void insertClient(ClientVO clientVO) {
		clientRepository.insertClient(clientVO.getCpf(),clientVO.getNome(),clientVO.getNomeReduzido(), 
				clientVO.getSexo(), clientVO.getEmail(), clientVO.getTelefone());
	}

}
