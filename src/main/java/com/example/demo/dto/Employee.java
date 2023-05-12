package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private int amount;

    public Employee(){
    }
    public Employee(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getEmpName() {
        return name;
    }

    public void setEmpName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

