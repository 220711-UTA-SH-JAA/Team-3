package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cart")
public class Cart{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cart_id")
	private Integer cartId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="cart_item_junction",
			joinColumns = {@JoinColumn(name="cart_id")},
			inverseJoinColumns = {@JoinColumn(name="item_id")}
	)
	private List<Item> items;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//@JoinColumn(name="user_id")
	//@JsonIgnore
	//private User user;
	
	public Cart() {
		super();
		items  = new ArrayList<>();
	}

	public Cart(Integer cartId, List<Item> items) {
		super();
		this.cartId = cartId;
		this.items = items;
//		this.user = user;
	}

	public Integer getListId() {
		return cartId;
	}

	public void setcartId(Integer cartId) {
		this.cartId = cartId;
	}


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	//public User getUser() {
//		return user;
//	}

//	public void setUser(User user) {
//		this.user = user;
//	}

//	@Override
//	public String toString() {
//		return "Cart [cartId=" + cartId + ", items=" + items + ", user=" + user.getUsername() + "]";
//	}
}