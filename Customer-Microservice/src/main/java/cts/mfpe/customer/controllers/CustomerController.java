package cts.mfpe.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cts.mfpe.customer.entities.Customer;
import cts.mfpe.customer.entities.Property;
import cts.mfpe.customer.entities.Requirement;
import cts.mfpe.customer.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getAllRequirements")
	public ResponseEntity<List<Requirement>> getAllRequirements(){
		return ResponseEntity.ok(customerService.getAllRequirements());
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
	    customerService.createCustomer(customer);
		return new ResponseEntity<>("Customer Created Successfully!",HttpStatus.CREATED);
	}
	
	@GetMapping("/getCustomerDetails/{id}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable int id) {
		return ResponseEntity.ok(customerService.getCustomerDetails(id));
	}
	
	@GetMapping("/getProperties")
	public ResponseEntity<List<Property>> getAllProperties(){
		return ResponseEntity.ok(customerService.getAllProperties());
	}
	
	@PutMapping("/{customerId}/assignRequirements/{requirementId}")
	public ResponseEntity<String> assignRequirements(@PathVariable("customerId") int custid, @PathVariable("requirementId") int reqid) {
		return new ResponseEntity<>("Requirement Assigned Successfully!",HttpStatus.OK);
	}
}
