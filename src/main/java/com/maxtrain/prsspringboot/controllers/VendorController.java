package com.maxtrain.prsspringboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxtrain.prsspringboot.entities.Request;
import com.maxtrain.prsspringboot.entities.Vendor;
import com.maxtrain.prsspringboot.repositories.VendorRepository;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	VendorRepository vendorRepo;

	@GetMapping("")
	public List<Vendor> getAll() {
		
		List<Vendor> vendor = vendorRepo.findAll();

		return vendor;
	}
	

	@GetMapping("/{id}")
	public Vendor getById(@PathVariable int id) {
		
		Vendor vendor = new Vendor();
		Optional<Vendor> optionalVendor = vendorRepo.findById(id);

		if (optionalVendor.isPresent()) {
			vendor = optionalVendor.get();
		}

		return vendor;
	}
	

	@PostMapping("")
	public Vendor createVendor(@RequestBody Vendor newVendor) {
		Vendor vendor = new Vendor();

		boolean vendorExists = vendorRepo.findById(newVendor.getId()).isPresent();

		if (!vendorExists) {
			vendor = vendorRepo.save(newVendor);
		}

		return vendor;
	}

	@PutMapping("")
	public Vendor update(@RequestBody Vendor updatedVendor) {
		Vendor vendor = new Vendor();

		boolean vendorExists = vendorRepo.findById(updatedVendor.getId()).isPresent();

		if (vendorExists) {
			vendor = vendorRepo.save(updatedVendor);

		}

		return vendor;
	}

	@DeleteMapping("{id}")
	public Vendor delete(@PathVariable int id) {
		Vendor vendor = new Vendor();
		Optional<Vendor> optionalVendor = vendorRepo.findById(id);

		boolean requestExists = optionalVendor.isPresent();

		if (requestExists) {
			vendor = optionalVendor.get();
			vendorRepo.deleteById(id);
		}

		return vendor;

	}

}
