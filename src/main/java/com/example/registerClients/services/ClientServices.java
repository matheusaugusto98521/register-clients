package com.example.registerClients.services;

import com.example.registerClients.model.Client;
import com.example.registerClients.model.dto.ClientRequestDTO;
import com.example.registerClients.model.exceptions.ClientNotFoundException;
import com.example.registerClients.model.exceptions.InvalidClientCredentialsException;
import com.example.registerClients.repository.IClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServices {

    @Autowired
    private IClientRepository repository;

    @Transactional
    public Client register(ClientRequestDTO data) throws InvalidClientCredentialsException {
        Client newClient = new Client();
        BeanUtils.copyProperties(data, newClient);
        if(calculateAge(newClient) < 16) throw new InvalidClientCredentialsException("Para se cadastrar cliente deve ter mais do que 16 anos de idade");
        return this.repository.save(newClient);
    }

    @Transactional
    public Client update(UUID idClient, ClientRequestDTO updatedData) throws ClientNotFoundException {
        var foundedClient = getClientById(idClient);
        BeanUtils.copyProperties(updatedData, foundedClient);
        return this.repository.save(foundedClient);
    }

    public void delete(UUID idClient) throws ClientNotFoundException {
        var foundedClient = getClientById(idClient);
        this.repository.delete(foundedClient);
    }

    public Client getClientById(UUID idClient) throws ClientNotFoundException {
        return this.repository.findById(idClient).orElseThrow(()
                -> new ClientNotFoundException("Cliente não encontrado para o ID: " + idClient));
    }

    public List<Client> getAll(){
        return this.repository.findAll();
    }

    private int calculateAge(Client client){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(convertDateToLocalDate(client.getBirthDate()), currentDate);

        return period.getYears();
    }

    private LocalDate convertDateToLocalDate(Date date){
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
