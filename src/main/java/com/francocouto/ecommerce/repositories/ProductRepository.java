package com.francocouto.ecommerce.repositories;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.francocouto.ecommerce.entities.Product;
import com.francocouto.ecommerce.projections.ProductProjection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<ProductProjection> searchByName(@Param("name") String name , Pageable pageable);


		
	
}
