package com.gym.crud;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	private  final ClientRepository clientRepository;
	HashMap<String, Object> datos ;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
		
	}
	public List<Client> getClient() {
		   
		   return this.clientRepository.findAll();
		   
	   }
	public ResponseEntity<Object> saveClient(Client client) {
		datos = new HashMap<>();
		// TODO Auto-generated method stub
	 Optional<Client> res = clientRepository.findClientByName(client.getName());
	 if(res.isPresent() && client.getId() ==null) {
		 datos.put("Error", true);
		 datos.put("Message", "Ya Existe un Cliente con ese Nombre");
		 return new ResponseEntity<>(
				 datos,HttpStatus.CONFLICT
				 );
	 }
	 
	 datos.put("message", "Se GUardo con Exito el CLiente ");
	 if(client.getId()!=null) {
		 datos.put("message", "Se Actualizo con Exito el CLiente ");
	 }
	 clientRepository.save(client);
	 datos.put("data", client);
	 
	 return new ResponseEntity<>(
			datos, HttpStatus.CREATED
			 );
		
	}
	
	public ResponseEntity<Object> deleteClient(Long id) {
		datos = new HashMap<>();
		
	boolean  existe =this.clientRepository.existsById(id);
    	if(!existe) {
    		 datos.put("Error", true);
    		 datos.put("Message", "No Existe el Cliente a Eliminar");
    		 return new ResponseEntity<>(
    				 datos,HttpStatus.CONFLICT
    				 );
    		
    	}
		
    	 datos.put("date", id);
    	 this.clientRepository.deleteById(id);
		 datos.put("Message", " El Cliente fue  Eliminado");
		 return new ResponseEntity<>(
				 datos,HttpStatus.ACCEPTED
				 );
		
	}

}
