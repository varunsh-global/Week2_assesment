package com.globallogic.springboot.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.springboot.assessment.entity.ProductEntity;
import com.globallogic.springboot.assessment.repository.CategoryRepo;
import com.globallogic.springboot.assessment.repository.ProductRepo;





@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	//use the GET All the data 
			@GetMapping("/")
			public List<ProductEntity> showProduct()
			{
				//return all the value from the tables
				return repo.findAll();
				
			}
			
			@PostMapping("/")
			public ProductEntity saveProduct(@RequestBody ProductEntity  prod)
			{
				
				System.err.println(prod);
				repo.save(prod);
				System.err.println(prod);
				return prod;
			}
			@PutMapping("/")
			public ProductEntity updateProduct(@RequestBody ProductEntity  prod)
			{
				
				repo.save(prod);
				System.err.println(prod);
				return prod;
			}
			
			
			//delete : it is used to delete the resource on the server
			@DeleteMapping("/{id}")
			public String deleteProduct(@PathVariable("id") int id)
			{
				System.err.println("deleted id is : "+id);
				repo.deleteById(id);
				return "Record Has been deleted !";
			}

}
