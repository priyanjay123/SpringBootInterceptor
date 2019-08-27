package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;

@RestController
public class ProductServiceController {
	private static Map<String, Product> productRepo = new HashMap<>();

	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		System.out.println("getProduct method of ProductServiceController called");
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}
}
