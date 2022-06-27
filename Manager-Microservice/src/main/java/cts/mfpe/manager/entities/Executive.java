package cts.mfpe.manager.entities;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Executive {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="Customer name cannot be null")
	private String name;
	@NotNull(message="Invalid Contact Number Entered")
	@Min(value=10,message="Contact Number should be minimum of 10 digits")
	@Max(value=10,message="Contact Number should be maximum of 10 digits")
	private long contactNumber;
	@NotNull(message="Locality cannot be null")
	private String locality;
	@Email(message="Invalid Email Entered")
	private String emailId;
	@ElementCollection
	private Set<Customer> customers;
}
