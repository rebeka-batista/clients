package br.com.clients.service;

import br.com.clients.dto.ClientDto;
import br.com.clients.entities.Client;
import br.com.clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientsService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public ClientDto insert(ClientDto dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDto(entity);
    }

    private void copyDtoToEntity(ClientDto dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

}
