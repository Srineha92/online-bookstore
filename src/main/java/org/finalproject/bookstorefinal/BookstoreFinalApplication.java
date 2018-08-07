package org.finalproject.bookstorefinal;

import org.finalproject.bookstorefinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BookstoreFinalApplication {

		public static void main(String[] args){
			SpringApplication.run(BookstoreFinalApplication.class, args);
		}
	}