package com.OMS.OrderService.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.OMS.OrderService.dto.OrderDetailsDTO;
import com.OMS.OrderService.dto.ProductsOrderedDTO;
import com.OMS.OrderService.entity.OrderDetails;
import com.OMS.OrderService.entity.ProductsOrdered;
import com.OMS.OrderService.repository.OrderRepository;
import com.OMS.OrderService.repository.ProductsOrderedRepository;
@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public OrderRepository orderrepo;
	
	@Autowired
	private ProductsOrderedRepository orderProdsRepo;
	@Autowired
	private ProductsOrdered productsOrdered;
	@Autowired
	public RestTemplate restTemplate;
	@Value("${userServiceUrl}")
	public String userServiceUrl;
	
	
	// This method is to view orders placed on products.(by buyerId)
	public ArrayList<OrderDetailsDTO> getAllOrders(Integer buyerId) {
		List<ProductsOrdered> product = (List<ProductsOrdered>) orderProdsRepo.findAll();
		ArrayList<OrderDetailsDTO> orders =new ArrayList<>();
		List<OrderDetails> ord= (List<OrderDetails>) orderrepo.findAll();
		for(OrderDetails ord1:ord) {
			if(ord1.getBuyerId().equals(buyerId)) {
				ArrayList<ProductsOrderedDTO> orderedProducts =new ArrayList<>();
				for(ProductsOrdered orderprod: product) {
					if(ord1.getOrderId().equals(orderprod.getOrderid())) {
						ProductsOrderedDTO prod =new ProductsOrderedDTO();
						prod.setOrderid(orderprod.getOrderid());
						prod.setPrice(orderprod.getPrice());
						prod.setProdid(orderprod.getProdid());
						prod.setQuantity(orderprod.getQuantity());
						prod.setSellerid(orderprod.getSellerid());
						prod.setStatus(orderprod.getStatus());
						orderedProducts.add(prod);
					}
					OrderDetailsDTO od= new OrderDetailsDTO();
					od.setAddress(ord1.getAddress());
					od.setAmount(ord1.getAmount());
					od.setBuyerid(ord1.getBuyerId()); 
					od.setDate(ord1.getDate());
					od.setOrderid(ord1.getOrderId());
					od.setStatus(ord1.getStatus());
					orders.add(od);
				}
			}
		}
		return orders;
		}
	
	// Deleting the order
	
	
	public String deleteOrder(Integer orderId) {
		List<OrderDetails> ordersEntities=(List<OrderDetails>) orderrepo.findAll();
				Integer sizeorder=ordersEntities.size();
				for(OrderDetails order: ordersEntities){
					if(order.getOrderId().equals(orderId)) {
						orderrepo.delete(order);					
					}
				}
				List<ProductsOrdered> products=(List<ProductsOrdered>) orderProdsRepo.findAll();
				Integer sizeproduct=products.size();
				// Deleting all the product ordered in that order
				for(ProductsOrdered product:products) {
					if(product.getOrderid().equals(orderId)) {
							orderProdsRepo.delete(product);
					}}
				List<OrderDetails> orders=(List<OrderDetails>) orderrepo.findAll();
				List<ProductsOrdered> prod=(List<ProductsOrdered>) orderProdsRepo.findAll();
				
			if(sizeorder>orders.size()& sizeproduct>prod.size()){
				return "Order "+ orderId+ " is deleted successfully from the records";
			}else{
				return "Deletion cannot be done as the order with orderId "+orderId+ " does not exist";
			}
		}
	
	// Updating status
	    public String updateStatus(Integer orderId, Integer prodId, String status) {
		     Boolean flag=false; 
					 try {
					 List<ProductsOrdered> products=(List<ProductsOrdered>) orderProdsRepo.findAll();
						 for(int i=0;i<products.size();i++){ 
						 ProductsOrdered product=products.get(i); 
						  if(product.getOrderid().equals(orderId) && product.getProdid().equals(prodId)) {
							  BeanUtils.copyProperties(product,productsOrdered);
							  orderProdsRepo.delete(product);
							  productsOrdered.setStatus(status);
							  orderProdsRepo.save(productsOrdered); 
							  flag=true; 
							  }
						  } 
					 }
					 catch(Exception e){
					  e.printStackTrace();
					  return "Error in updating the order! Contact your Admin"; 
					  } 
					  if(flag){
						return  "Order status updated successfully";
						}
					  else{ 
						return "Updation is not successful. Check for issues"; 
						} 
		  }
				  
		  		  
		
	public Integer[] usingRewardPoints(Integer buyerId, int eligibleDiscount) {
        String getrewardUrl=userServiceUrl+"rewardPoint/"+buyerId;
        
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(getrewardUrl, Integer.class);
       
        Integer reward=responseEntity.getBody();
        Integer discount=reward/4;
        if(discount>eligibleDiscount) {
            discount=eligibleDiscount;
            reward=reward-eligibleDiscount*4;
        }else {
            reward=0;
        }
        Integer [] valuesArray=new Integer[2];
        valuesArray[0]=discount;valuesArray[1]=reward;
        return valuesArray;
	}
		
			
	
}
