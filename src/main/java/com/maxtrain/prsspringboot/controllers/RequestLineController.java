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
import com.maxtrain.prsspringboot.entities.RequestLine;
import com.maxtrain.prsspringboot.entities.Vendor;
import com.maxtrain.prsspringboot.repositories.RequestLineRepository;

@RestController
@RequestMapping("/request-lines")
public class RequestLineController {

	@Autowired
	private RequestLineRepository requestLineRepo;

	@GetMapping("")
	public List<RequestLine> getAll() {
		List<RequestLine> requestLine = requestLineRepo.findAll();

		return requestLine;
	}

	@GetMapping("/{id}")
	public RequestLine getById(@PathVariable int id) {
		RequestLine requestLine = new RequestLine();
		Optional<RequestLine> optionalRequestLine = requestLineRepo.findById(id);

		if (optionalRequestLine.isPresent()) {
			requestLine = optionalRequestLine.get();
		}

		return requestLine;
	}

	@PostMapping("")
	public RequestLine create(@RequestBody RequestLine newRequestLine) {
		RequestLine requestLine = new RequestLine();

		boolean userExists = requestLineRepo.findById(newRequestLine.getId()).isPresent();

		if (!userExists) {
			requestLine = requestLineRepo.save(newRequestLine);
		}

		return requestLine;
	}

	@PutMapping("")
	public RequestLine update(@RequestBody RequestLine updatedRequestLine) {
		RequestLine requestLine = new RequestLine();

		boolean requestLineExists = requestLineRepo.findById(updatedRequestLine.getId()).isPresent();

		if (requestLineExists) {
			requestLine = requestLineRepo.save(updatedRequestLine);
		}

		return requestLine;

	}

	@DeleteMapping("{id}")
	public RequestLine delete(@PathVariable int id) {
		RequestLine requestLine = new RequestLine();
		Optional<RequestLine> optionalRequestLine = requestLineRepo.findById(id);

		boolean requestExists = optionalRequestLine.isPresent();

		if (requestExists) {
			requestLine = optionalRequestLine.get();
			requestLineRepo.deleteById(id);
		}

		return requestLine;
	}
	
	public RequestLine update() {
		RequestLine line = new RequestLine();
		
		//male the update call to the RequestLineRepository
		
		recalculateTotal(line.getRequest());
		
		return line;
	}

	
	
	private recalculateTotal(int requestId) {
		RequestLine line = new RequestLine();
		// get a list of RequesLines for the request that we are recalculating
		// This requires a new repository method
		List<RequestLine> requestLines = requestLineRepo.//something ();
				
		// Loop through the list of RequestLines (enhanced for each loop)
		// For each RequestLine, calculate the total of the line (qty * item), keep running total
		// Set recalculated total to the request that we are recalculating
		//Save the request to the Requests table in our database
				
		// Hint Use RequestRepo inside the requestController @Autowired in the RequestRepository ??
		
	}
	
}
