package com.OMS.OrderService.controller;

	import java.util.ArrayList;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.client.RestTemplate;

	import com.OMS.OrderService.dto.OrderDetailsDTO;
	import com.OMS.OrderService.dto.ProductsOrderedDTO;
	import com.OMS.OrderService.service.OrderService;

	@RestController
	public class OrderServiceController {
		
		@Autowired
		private OrderService orderservice;
		@Autowired
		public RestTemplate restTemplate;
		@Value("${userServiceUrl}")
		public String cartServiceUrl;
		@Value("${productServiceUrl}")
		public String productServiceUrl;
		
		
		
			@GetMapping(value="/orders/{buyerId}", produces= MediaType.APPLICATION_JSON_VALUE)
			public ArrayList <OrderDetailsDTO> getAllOrders(@PathVariable("buyerId") Integer buyerId ) {
				return orderservice.getAllOrders(buyerId);	
			}
			
			@RequestMapping(method=RequestMethod.PUT,value="/orders/status")
			public String updateStatus (@RequestBody ProductsOrderedDTO product) {
				Integer orderId=product.getOrderid();
				Integer prodId=product.getProdid();
				String status= product.getStatus();
				return orderservice.updateStatus(orderId,prodId,status);
			}
			
			@DeleteMapping(value="/orders/delete/{orderId}", consumes= MediaType.APPLICATION_JSON_VALUE)
			public String deleteOrder(@PathVariable("orderId") Integer orderId ) {
				return orderservice.deleteOrder(orderId);
			}
	}
	
