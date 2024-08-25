package com.jkcreation.Collegify.entity;

import java.math.BigDecimal;

public class StudentInput {

    private BigDecimal percentile;
    private String department;
    private Cutoff.Category category;

    // Getters and Setters

    public BigDecimal getPercentile() {
        return percentile;
    }

    public void setPercentile(BigDecimal percentile) {
        this.percentile = percentile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Cutoff.Category getCategory() {
        return category;
    }

    public void setCategory(Cutoff.Category category) {
        this.category = category;
    }
}