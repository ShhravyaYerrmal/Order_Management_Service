package com.OMS.OrderService.dto;


import java.math.BigDecimal;

import com.OMS.OrderService.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	
	Integer prodid;
	
	Integer orderid;
	
	Integer sellerid;
	
	Integer quantity;
	
	String status;
	
	BigDecimal price;
	
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
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
	public static ProductsOrderedDTO valueOf(ProductsOrdered productsordered) {
		ProductsOrderedDTO productsorderedDTO = new ProductsOrderedDTO();
		productsorderedDTO.setOrderid(productsordered.getOrderid());
		//productsorderedDTO.setProductid(productsordered.getProductid());
		productsorderedDTO.setPrice(productsordered.getPrice());
		productsorderedDTO.setProdid(productsordered.getProdid());
		productsorderedDTO.setQuantity(productsordered.getQuantity());
		productsorderedDTO.setSellerid(productsordered.getSellerid());
		productsorderedDTO.setStatus(productsordered.getStatus());
		return productsorderedDTO;
	}
	
		
	@Override
	public String toString() {
		return "ProductsOrderedDTO [OrderId=" + orderid + ",ProdId=" + prodid + ", Price=" + price
				+ ", Quantity=" + quantity + ", SellerId=" + sellerid + ", Status =" + status +"]";
	}
	
}