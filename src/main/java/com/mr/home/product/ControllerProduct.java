package com.mr.home.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProduct {
	@Autowired
	ServiceProduct serviceProduct;

	@GetMapping("/home")
	public String home() {
		return "welcome to home";
	}

	@GetMapping("/allproduct")
	public List<EntityProduct> findAllProduct() {
		return serviceProduct.getAllProduct();
	}

	@GetMapping("product/{id}")
	public Optional<EntityProduct> findProductById(@PathVariable("id") int id) {
		return serviceProduct.findProduct(id);
	}

	@PostMapping("/createproduct")
	public EntityProduct creaeProduct(@RequestBody EntityProduct entityProduct) {
		EntityProduct product = null;
		product = serviceProduct.createProduct(entityProduct);
		return product;
	}

	@PutMapping("/updateproduct/{id}")
	public EntityProduct updateProduct(@PathVariable("id") int id, @RequestBody EntityProduct entityProduct) {
		EntityProduct updateProduct = new EntityProduct();
		updateProduct = serviceProduct.updateProduct(id, entityProduct);
		return updateProduct;
	}

	@DeleteMapping("deletproduct/{id}")
	public void deletProductById(@PathVariable("id") int id) {
		serviceProduct.deletProduct(id);
	}

	
}
