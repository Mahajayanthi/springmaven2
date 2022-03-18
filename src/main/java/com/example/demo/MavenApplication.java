package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MavenApplication {
	@GetMapping("/message")
public String message() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader("java.txt"));
		String everything;
    	try {
    	    StringBuilder sb = new StringBuilder();
    	    String line = br.readLine();

    	    while (line != null) {
    	        sb.append(line);
    	        sb.append(System.lineSeparator());
    	        line = br.readLine();
    	    }
    	    everything = sb.toString();
    	    System.out.println(everything);
    	} finally {
    	    br.close();
    	}
		return everything;
	}
	public static void main(String[] args)
	{
		SpringApplication.run(MavenApplication.class, args);
	}

}
