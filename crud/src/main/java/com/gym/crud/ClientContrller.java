package com.gym.crud;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "api/v1/client")

public class ClientContrller {
	
 private final ClientService clientService;
 
 @Autowired
 public ClientContrller(ClientService clientService) {
	 this.clientService = clientService;
	 
 }
 @GetMapping
 public List<Client> getClients(){
	 return this.clientService.getClient();
 }
 
 @PostMapping
 
  public ResponseEntity<Object> saveClient(@RequestBody Client client) {
	 
	return  this.clientService.saveClient(client);
	 
 }
 
 @PutMapping
 
 public ResponseEntity<Object> updateClient(@RequestBody Client client) {
	 
	return  this.clientService.saveClient(client);
	 
}
 
 @DeleteMapping(path = "{clientId}")
 
 public ResponseEntity<Object> deleteClient(@PathVariable ("clientId")Long id ) {
	 
	return  this.clientService.deleteClient(id);
	 
}
}
