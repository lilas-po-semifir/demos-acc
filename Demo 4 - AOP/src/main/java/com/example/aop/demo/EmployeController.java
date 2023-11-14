package com.example.aop.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe")
public class EmployeController {
  private final EmployeService employeService;

  public EmployeController(EmployeService employeService){
    this.employeService = employeService;
  }

  @PostMapping("")
  public Employe creerEmploye(@RequestBody Employe employe){
    return employeService.create(employe);
  }

  @GetMapping("/{id}")
  public Employe recupererEmploye(@PathVariable int id){
    return employeService.read(id);
  }

  @GetMapping("")
  public List<Employe> recupererTousLesEmployes(){
    return employeService.readAll();
  }

  @PutMapping("")
  public Employe majEmploye(@RequestBody Employe employe){
    return employeService.update(employe);
  }

  @DeleteMapping("/{id}")
  public void supprimerEmploye(@PathVariable int id){
    employeService.delete(id);
  }
}
