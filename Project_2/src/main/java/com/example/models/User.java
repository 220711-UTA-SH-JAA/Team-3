package com.example.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
@Table(name = "users")
public class User {

	// Primary Key
	@Id

	// Auto-generate id value
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Add different column constraints
	@Column(name = "user_id")
	public Integer user_Id;

	@Column(name = "user_first_name")
	public String firstName;

	@Column(name = "user_last_name")
	public String lastName;

	// Unique constraint
	@Column(unique = true)
	public String email;

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Column(unique = true)
	public String username;

	public String password;
	
	@OneToMany(mappedBy="user", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Order> orders;
	

	public User(String firstName, String lastName, String email, String username, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;

	}

	public User() {
		super();
	}

	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}

}
