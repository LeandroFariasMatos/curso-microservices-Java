package com.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.model.Book;
import com.bookservice.proxy.CambioProxy;
import com.bookservice.repository.BookRepository;
import com.bookservice.response.Cambio;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.Proxy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CambioProxy cambioProxy;
	
	@Operation(summary = "Find a specific book by your ID")
	@GetMapping(value="/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id,
						 @PathVariable("currency") String currency) {
		
		var book = bookRepository.getReferenceById(id);
		if(book == null) throw new RuntimeException("book not found");
		
		var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = environment.getProperty("local.server.port");
		
		book.setEnviroment("Book port:"+port+" Cambio port :"+cambio.getEnvironment());
		book.setPrice(cambio.getConvertedValue());
		return book;
		
	}

}
