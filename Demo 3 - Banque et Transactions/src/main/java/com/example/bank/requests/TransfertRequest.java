package com.example.bank.requests;

public class TransfertRequest {
  public TransfertRequest(){

  }

  private int idCompteADebiter;
  private int idCompteACrediter;
  private long montantACrediter;

  public int getIdCompteADebiter() {
    return idCompteADebiter;
  }

  public void setIdCompteADebiter(int idCompteADebiter) {
    this.idCompteADebiter = idCompteADebiter;
  }

  public int getIdCompteACrediter() {
    return idCompteACrediter;
  }

  public void setIdCompteACrediter(int idCompteACrediter) {
    this.idCompteACrediter = idCompteACrediter;
  }

  public long getMontantACrediter() {
    return montantACrediter;
  }

  public void setMontantACrediter(long montantACrediter) {
    this.montantACrediter = montantACrediter;
  }
}
