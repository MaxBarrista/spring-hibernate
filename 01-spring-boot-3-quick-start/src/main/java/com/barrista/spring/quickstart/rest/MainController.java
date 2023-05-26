package com.barrista.spring.quickstart.rest;

import com.barrista.spring.quickstart.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

  @Value("${custom.value1}")
  private String customValue1;

  private DummyService dummyService;

  @Autowired
  public void setDummyService(DummyService dummyService) {
    this.dummyService = dummyService;
  }

  @GetMapping
  public String greeting() {
    return "Hello world! " + customValue1;
  }

  @GetMapping("foo")
  public String foo() {
    return dummyService.foo();
  }
}
