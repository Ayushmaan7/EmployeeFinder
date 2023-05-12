package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bonus")
public class Bonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "amount")
    private int amount;
    @Column(name = "currency")
    private String currency;
    @Column(name = "joining_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate joiningDate;
    @Column(name = "exit_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate exitDate;

    public Bonus(String curr, int amount) {
        this.currency = curr;
        this.amount = amount;
    }


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }
}

