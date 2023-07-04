package hodi.karibu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hodi.karibu.model.product.Product;
import hodi.karibu.model.user.User;
import hodi.karibu.service.ProductService;
import hodi.karibu.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAndProductController {
	
	private final ProductService productService;
	private final UserService userService;
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();	
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

}
