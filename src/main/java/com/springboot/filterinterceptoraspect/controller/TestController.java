package com.springboot.filterinterceptoraspect.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/filter")
  public String filter(@RequestParam("name") String name) {
    return "filter success"+name;
  }
  @GetMapping("/test")
  public String test(@RequestParam("name") String name) {
    return "test"+name;
  }
}
