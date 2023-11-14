package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatriceService {
  public CalculatriceService(){

  }

  public int addition(int x, int y){
    return x + y;
  }

  public int soustraction(int x, int y){
    return x - y;
  }

  public int multiplication(int x, int y){
    return x * y;
  }
}
