package com.example.demo.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testGetEmpName() {
        Employee employee = new Employee("John Doe", 1000);
        assertEquals("John Doe", employee.getEmpName());
    }

    @Test
    public void testSetEmpName() {
        Employee employee = new Employee("John Doe", 1000);
        employee.setEmpName("Jane Smith");
        assertEquals("Jane Smith", employee.getEmpName());
    }

    @Test
    public void testGetAmount() {
        Employee employee = new Employee("John Doe", 1000);
        assertEquals(1000, employee.getAmount());
    }

    @Test
    public void testSetAmount() {
        Employee employee = new Employee("John Doe", 1000);
        employee.setAmount(2000);
        assertEquals(2000, employee.getAmount());
    }
}


