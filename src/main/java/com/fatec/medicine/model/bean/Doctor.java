package com.fatec.medicine.model.bean;

public class Doctor {
    private Long id;
    private String name;
    private String crm;
    private String specializations;

    public Doctor() { }

    public Doctor(String name, String crm, String specializations) {
        this.name = name;
        this.crm = crm;
        this.specializations = specializations;
    }

    public Doctor(Long id, String name, String crm, String specializations) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.specializations = specializations;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }
}
