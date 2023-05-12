package com.example.demo.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {

    @Test
    public void testGettersAndSetters() {
        Bonus bonus = new Bonus("USD", 100);

        bonus.setEmpName("John");
        assertEquals("John", bonus.getEmpName());

        bonus.setAmount(200);
        assertEquals(200, bonus.getAmount());

        bonus.setCurrency("EUR");
        assertEquals("EUR", bonus.getCurrency());

        LocalDate joiningDate = LocalDate.of(2022, 1, 1);
        bonus.setJoiningDate(joiningDate);
        assertEquals(joiningDate, bonus.getJoiningDate());

        LocalDate exitDate = LocalDate.of(2023, 1, 1);
        bonus.setExitDate(exitDate);
        assertEquals(exitDate, bonus.getExitDate());
    }
}
