package com.example.demo.controllers;

import com.example.demo.RequeteMultiplication;
import com.example.demo.services.CalculatriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calc")
public class CalculatriceController {
  private final CalculatriceService service;

  public CalculatriceController(CalculatriceService service){
    this.service = service;
  }

  @GetMapping("/addition")
  public int addition(@RequestParam int x, @RequestParam int y){
    return service.addition(x, y);
  }

  @GetMapping("/soustraction/{x}-{y}")
  public int soustraction(@PathVariable int x, @PathVariable int y){
    return service.soustraction(x, y);
  }

  @GetMapping("/multiplication")
  public int multiplication(@RequestBody RequeteMultiplication requeteMultiplication){
    return service.multiplication(
        requeteMultiplication.getX(),
        requeteMultiplication.getY()
    );
  }
}
