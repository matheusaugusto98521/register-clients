package com.example.registerClients.controller;

import com.example.registerClients.model.Client;
import com.example.registerClients.model.dto.ClientRequestDTO;
import com.example.registerClients.model.exceptions.ClientNotFoundException;
import com.example.registerClients.model.exceptions.InvalidClientCredentialsException;
import com.example.registerClients.services.ClientServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientServices services;

    @PostMapping("/register")
    public ResponseEntity<Client> register(@RequestBody @Valid ClientRequestDTO data) throws InvalidClientCredentialsException {
        return ResponseEntity.status(HttpStatus.OK).body(this.services.register(data));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam("idClient")UUID idClient,
                                    @RequestBody @Valid ClientRequestDTO updatedData) throws ClientNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(this.services.update(idClient, updatedData));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("idClient")UUID idClient) throws ClientNotFoundException {
        this.services.delete(idClient);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Client> getById(@RequestParam("idClient")UUID idClient) throws ClientNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(this.services.getClientById(idClient));
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.services.getAll());
    }
}
