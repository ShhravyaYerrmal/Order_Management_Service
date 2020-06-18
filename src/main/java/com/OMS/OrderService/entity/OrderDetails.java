package com.OMS.OrderService.entity;

import java.math.BigDecimal;
import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ORDERID", nullable=false, updatable=false)
	private Integer orderId;
	
	@Column(name="BUYERID", nullable=false)
	private Integer buyerId;
	
	@Column(name="AMOUNT", nullable=false,precision = 10, scale = 2)
	private BigDecimal amount;
	
	@Column(name="DATE", nullable=false)
	private Date date;
	
	@Column(name="ADDRESS", nullable=false)
	private String address;
	
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", buyerId=" + buyerId + ", amount=" + amount + ", date=" + date
				+ ", address=" + address + ", status=" + status + "]";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal bigDecimal) {
		this.amount = bigDecimal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="STATUS", nullable=false)
	private String status;
	
		
	
	
}
