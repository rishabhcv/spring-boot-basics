package com.esp.bootapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esp.domain.Books;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Books> getBooks() {
		return Arrays.asList(new Books(1, "Spring", "Rod Johnson"));
	}

}
