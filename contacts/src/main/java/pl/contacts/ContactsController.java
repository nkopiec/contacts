package pl.contacts;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController{
	
	private List<Contacts> contactList = new LinkedList<>();
	private Contacts contacts;
	

	@GetMapping//OK
	public ResponseEntity<List<Contacts>> getAll() {
		return new ResponseEntity<List<Contacts>> (contactList, HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contacts> getOne(@PathVariable long id) {
		return new ResponseEntity<Contacts>(HttpStatus.OK);
	}	
	
	@PostMapping//OK
	public ResponseEntity<Void> create(@RequestBody Contacts contacts) {
		contactList.add(contacts);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Contacts> responseEntity(Long id) {	
//			return new ResponseEntity<Contacts>(HttpStatus.OK);		
//	}
	
	@DeleteMapping("/{id}")//czysci liste
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		contactList.clear();//remove(contacts);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
