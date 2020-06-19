package com.revature.cats.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.revature.cats.exceptions.CatNotFoundException;
import com.revature.cats.models.Cat;
import com.revature.cats.services.CatService;

@RestController
public class CatController {
	
	@Autowired
	CatService catService;
	
	@GetMapping("/hello")
	public String testEndpoint() {
		return "Hello";
	}
	
	@GetMapping("/randomcat")
	public Cat testCatEndpoint() {
		Cat cat = new Cat();
		cat.setCatId(3);
		cat.setName("biscuit");
		cat.setCuteness(55.5);
		return cat;
	}
	
	@GetMapping("/cats")
	public List<Cat> getAllCats() {
		return catService.getAll();
	}
	
	@GetMapping("/cats/{id}")
	public Cat getCatById(@PathVariable Integer id) {
		try {
			return catService.getById(id);
		}catch(CatNotFoundException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat not found", e);
		}
		
	}
	
	@PostMapping("/cats")
	public Cat addNewCat(@RequestBody Cat cat) {
		return catService.create(cat);
	}
	
	@PutMapping("/cats/{id}")
	public Cat createOrUpdateCatWithId(@RequestBody Cat cat, @PathVariable Integer id) {
		cat.setCatId(id);
		return catService.createOrUpdate(cat);
	}
	
	@PatchMapping("/cats/{id}")
	public Cat updateCatWithId(@RequestBody Cat cat, @PathVariable Integer id) {
		cat.setCatId(id);
		return catService.update(cat);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/cats/{id}")
	public void deleteCat(@PathVariable Integer id) {
		catService.delete(id);
	}
}
