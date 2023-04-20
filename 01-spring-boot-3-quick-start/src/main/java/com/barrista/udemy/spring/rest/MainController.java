package com.barrista.udemy.spring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

  @Value("${custom.value1}")
  private String customValue1;

  @GetMapping()
  public String greeting() {
//    throw new RuntimeException("test logging level");
    return "Hello world! Custom value: " + customValue1;
  }
}
