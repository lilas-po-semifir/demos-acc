package com.example.aop.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
  private final EmployeRepository employeRepository;

  public EmployeService(EmployeRepository employeRepository){
    this.employeRepository = employeRepository;
  }

  public Employe create(Employe employe){
    return employeRepository.save(employe);
  }

  public Employe read(int id){
    return employeRepository.findById(id).orElseThrow();
  }

  public List<Employe> readAll(){
    return employeRepository.findAll();
  }

  public Employe update(Employe employe){
    Employe employeExistant = employeRepository.findById(employe.getId()).orElseThrow();
    employeExistant.setNom(employe.getNom());
    employeExistant.setPrenom(employe.getPrenom());
    return employeRepository.save(employeExistant);
  }

  public void delete(int id){
    employeRepository.deleteById(id);
  }
}
