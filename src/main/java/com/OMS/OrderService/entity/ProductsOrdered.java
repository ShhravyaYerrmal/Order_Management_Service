package com.OMS.OrderService.entity;

import java.io.Serializable;
import java.math.BigDecimal;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Id;
import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Entity
@IdClass(value=ProductsOrdered.class)
@Table(name="productsordered")
public class ProductsOrdered implements Serializable{
	@Id
	Integer orderid;
	@Id
	@Column(name="PRODID")
	Integer prodid;
	//@EmbeddedId
	//Integer productid;
	@Column(name="SELLERID",nullable = false)
	Integer sellerid;
	@Column(name="QUANTITY",nullable = false)
	Integer quantity;
	@Column(name="STATUS",nullable = false, length=60)
	String status;
	@Column(name="PRICE",length=10)
	BigDecimal price;
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ProductsOrdered() {
		super();
	}
	
	
	
}
