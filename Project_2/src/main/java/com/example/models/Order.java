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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	public Integer orderId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="order_item_junction",
			joinColumns = {@JoinColumn(name="order_id")},
			inverseJoinColumns = {@JoinColumn(name="item_id")}
	)
	
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn(name="user_id")
//	@JsonIgnore
	
	
	@Id
	// Auto-generate id value
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_Id")
	public Integer order_Id;
	
	@Column(name = "user")
	public Integer user;
	
	@Column(name = "items")
	public List<Item> items;
	
	public Order() {
		super();
		items  = new ArrayList<>();
	}

	public Order( List<Item> items, Integer userId) {
		//Integer orderId,
		super();
		//this.orderId = orderId;
		this.items = items;
		this.user = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getUserId() {
		return user;
	}

	public void setUserId(Integer user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [order_Id=" + order_Id + ", items=" + items + ", userId=" + user + "]";
	}
}