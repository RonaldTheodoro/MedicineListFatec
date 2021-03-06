package com.fatec.medicine.model.bean;

public class Patient {
    private Long id;
    private String name;
    private String cpf;
    private double weight;
    private double height;

    public Patient() { }

    public Patient(
            String name, 
            String cpf,
            double weight, 
            double height) {
        this.name = name;
        this.cpf = cpf;
        this.weight = weight;
        this.height = height;
    }

    public Patient(
            Long id, 
            String name, 
            String cpf, 
            double weight, 
            double height) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.weight = weight;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
