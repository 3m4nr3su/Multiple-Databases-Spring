package hodi.karibu.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hodi.karibu.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
