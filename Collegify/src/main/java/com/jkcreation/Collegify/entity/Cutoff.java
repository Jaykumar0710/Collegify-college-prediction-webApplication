package com.jkcreation.Collegify.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import org.hibernate.annotations.ManyToAny;

import java.math.BigDecimal;

@Entity
public class Cutoff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    private String department;

    @Enumerated(EnumType.STRING)
    private Category category;

    private BigDecimal percentile;
    private int year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPercentile() {
        return percentile;
    }

    public void setPercentile(BigDecimal percentile) {
        this.percentile = percentile;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public enum Category{
        GENERAL, OBC, SC, ST
    }
}
