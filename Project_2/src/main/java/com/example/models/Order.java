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
@Table(name="order")
public class Order{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Integer orderId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="order_item_junction",
			joinColumns = {@JoinColumn(name="order_id")},
			inverseJoinColumns = {@JoinColumn(name="item_id")}
	)
	private List<Item> items;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	public Order() {
		super();
		items  = new ArrayList<>();
	}

	public Order(Integer orderId, List<Item> items, User user) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + ", user=" + user.getUsername() + "]";
	}
}