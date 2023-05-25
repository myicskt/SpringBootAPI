package com.mr.home.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduct {

	@Autowired
	RepoProduct repoProduct;

	public List<EntityProduct> getAllProduct() {
		return repoProduct.findAll();
	}

	public Optional<EntityProduct> findProduct(int id) {
		return repoProduct.findById(id);
	}

	public EntityProduct createProduct(EntityProduct entityProduct) {
		EntityProduct product = new EntityProduct();
		product.setProductName(entityProduct.getProductName());
		product.setProductPrice(entityProduct.getProductPrice());
		product = repoProduct.save(entityProduct);
		return product;
	}

	public EntityProduct updateProduct(int id, EntityProduct entityProduct) {
		EntityProduct updateProduct = new EntityProduct();
		Optional checkProduct = repoProduct.findById(id);
		if (checkProduct.isPresent()) {
			updateProduct = (EntityProduct) checkProduct.get();
			updateProduct.setProductName(entityProduct.getProductName());
			updateProduct.setProductPrice(entityProduct.getProductPrice());
			updateProduct = repoProduct.save(updateProduct);
		}
		return updateProduct;
	}
	public void deletProduct(int id) {
		repoProduct.deleteById(id);
	}

}
