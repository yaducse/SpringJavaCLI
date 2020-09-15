package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DemoRunner implements CommandLineRunner {

	@Override
    public void run(String... args) throws IOException {

   try {
	     //create ObjectMapper instance
       ObjectMapper objectMapper = new ObjectMapper();
       
       String filePath=args[0];
       
       String extension = "";

       int i = filePath.lastIndexOf('.');
       if (i > 0) {
           extension += filePath.substring(i);
       }
   
       if (extension.equals(".json")) {
       	Map<?, ?> map = objectMapper.readValue(new FileInputStream(filePath), Map.class);

 	      	//iterate over map entries and print to console
       	
 	      	for (Map.Entry<?, ?> entry : map.entrySet()) {
 	          System.out.println(entry.getKey() + "=" + entry.getValue());
 	      	}
       }
       else {
       	System.out.println("ERROR!!! Enter a JSON file path");
       }
  
   }catch(ArrayIndexOutOfBoundsException e) {
	   System.out.println(e+" Enter a file path!");
   }
    }

}
