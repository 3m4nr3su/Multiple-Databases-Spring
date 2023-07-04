package hodi.karibu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hodi.karibu.model.product.Product;
import hodi.karibu.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepo;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

}
