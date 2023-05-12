package com.example.demo.controller;

import com.example.demo.dto.Bonus;
import com.example.demo.dto.Employee;
import com.example.demo.service.BonusCalculator;
import com.example.demo.service.EmployeeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BonusControllerTest {

    @Mock
    private BonusCalculator bonusCalculator;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private BonusController bonusController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateBonusEligibility() {
        // Mock request body with a single bonus
        List<Bonus> bonuses = new ArrayList<>();
        bonuses.add(new Bonus("USD", 5000));
        Map<String, List<Bonus>> requestBody = new HashMap<>();
        requestBody.put("bonus", bonuses);
        // Mock bonusCalculator service response
        Map<String, List<Employee>> employeesByCurrency = new HashMap<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 1000));
        employeesByCurrency.put("USD", employees);
        when(bonusCalculator.calculate(bonuses)).thenReturn(employeesByCurrency);

        // Build expected JSON response
        Map<String, List<Map<String, Object>>> expectedResponse = new HashMap<>();
        List<Map<String, Object>> currencyDataList = new ArrayList<>();
        Map<String, Object> employeeData = new HashMap<>();
        employeeData.put("name", "John Doe");
        employeeData.put("amount", 1000);
        List<Map<String, Object>> employeesData = new ArrayList<>();
        employeesData.add(employeeData);
        Map<String, Object> currencyData = new HashMap<>();
        currencyData.put("currency", "USD");
        currencyData.put("employees", employeesData);
        currencyDataList.add(currencyData);
        expectedResponse.put("data", currencyDataList);

        // Invoke the controller method and compare response with expected
        ResponseEntity<Map<String, List<Map<String, Object>>>> response = bonusController.calculateBonusEligibility(requestBody);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }
}