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
@Table(name="orders")
public class Order{
	
	@Id
	// Auto-generate id value
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id")
	public Integer order_Id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="user_id")
	@JsonIgnore
	public User user;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="order_item_junction",
			joinColumns = {@JoinColumn(name="order_id")},
			inverseJoinColumns = {@JoinColumn(name="item_id")}
	)
	@Column(name = "items")
	public List<Item> items;
	
	public Order() {
		super();
		items  = new ArrayList<>();
	}



	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}



	@Override
	public String toString() {
		return "Order [order_Id=" + order_Id + ", items=" + items + ", userId=" + user + "]";
	}
}