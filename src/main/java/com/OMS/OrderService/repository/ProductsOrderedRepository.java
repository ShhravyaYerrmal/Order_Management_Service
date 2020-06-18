package com.OMS.OrderService.repository;





//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.OMS.OrderService.entity.OrderDetails;
import com.OMS.OrderService.entity.ProductsOrdered;

@Repository
public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, Integer>{
	
	
}

