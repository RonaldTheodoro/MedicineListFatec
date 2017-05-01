package com.fatec.medicine.model.bean;

public class Medicine {
    private Long id;
    private String activeIngredient;
    private String commercialName;
    private String amount;

    public Medicine() { }

    public Medicine(String activeIngredient, String commercialName, String amount) {
        this.activeIngredient = activeIngredient;
        this.commercialName = commercialName;
        this.amount = amount;
    }

    public Medicine(Long id, String activeIngredient, String commercialName, String amount) {
        this.id = id;
        this.activeIngredient = activeIngredient;
        this.commercialName = commercialName;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
