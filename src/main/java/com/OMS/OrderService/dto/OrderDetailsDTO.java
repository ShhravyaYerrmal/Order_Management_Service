package com.OMS.OrderService.dto;

import java.math.BigDecimal;
import java.util.Date;


import com.OMS.OrderService.entity.OrderDetails;

public class OrderDetailsDTO {
	
	Integer orderid;
	Integer buyerid;
	BigDecimal amount;
	Date date;
	String address;
	String status;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static OrderDetailsDTO  valueOf(OrderDetails orderdetails) {
		OrderDetailsDTO orderdetailsDTO=new OrderDetailsDTO();
		orderdetailsDTO.setAddress(orderdetails.getAddress());
		orderdetailsDTO.setAmount(orderdetails.getAmount());
		orderdetailsDTO.setBuyerid(orderdetails.getBuyerId());
		orderdetailsDTO.setDate(orderdetails.getDate());
		orderdetailsDTO.setOrderid(orderdetails.getOrderId());
		orderdetailsDTO.setStatus(orderdetails.getStatus());
		return orderdetailsDTO;
	}
	@Override
	public String toString() {
		return "OrderDetailsDTO [BuyerId=" + buyerid + ", OrderId=" + orderid + ", Amount=" + amount
				+ ", Date=" + date + ", Address=" + address + ", Status =" + status +"]";
	}

	public OrderDetails createEntity() {
		OrderDetails order = new OrderDetails();
		order.setAddress(this.getAddress());
		order.setAmount(this.getAmount());
		order.setBuyerId(this.getBuyerid());
		order.setDate(this.getDate());
		order.setOrderId(this.getOrderid());
		order.setStatus(this.getStatus());
		
		return order;
	}
	
	
}