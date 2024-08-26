package com.example.ProductServiceAug24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class SampleController {

    @GetMapping("")
   public String HelloWorld(){
       return "Hello World";
   }
   @GetMapping("/{name}")
   public String HelloName(@PathVariable("name") String name){
        return "Hello"+" "+ name;
   }
   @GetMapping("/show/{show_id}/seat/{seat_id}")
   public String booktickets(@PathVariable("show_id")String showid, @PathVariable("seat_id") String seatid){
        return "Book Tickets"+" "+showid+" "+seatid;
   }
}
