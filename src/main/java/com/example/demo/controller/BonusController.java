package com.example.demo.controller;

import com.example.demo.service.BonusCalculator;
import com.example.demo.service.EmployeeMapper;
import com.example.demo.dto.Bonus;
import com.example.demo.dto.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tci/bonus")
public class BonusController {
    private final BonusCalculator bonusCalculator;
    private final EmployeeMapper employeeMapper;

    public BonusController(BonusCalculator bonusCalculator, EmployeeMapper employeeMapper) {
        this.bonusCalculator = bonusCalculator;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("/eligibility")
    public ResponseEntity<Map<String, List<Map<String, Object>>>> calculateBonusEligibility(@RequestBody Map<String, List<Bonus>> requestBody) {
        List<Bonus> bonuses = requestBody.get("bonus");

        // Call the bonus calculator service to get eligible employees
        Map<String, List<Employee>> employeesByCurrencySortedByName = bonusCalculator.calculate(bonuses);


        // Convert the employee hashmap to JSON response format
        Map<String, List<Map<String, Object>>> jsonResponse = new HashMap<>();
        List<Map<String, Object>> currencyDataList = new ArrayList<>();
        for (Map.Entry<String, List<Employee>> entry : employeesByCurrencySortedByName.entrySet()) {
            String currency = entry.getKey();
            List<Employee> employees = entry.getValue();

            List<Map<String, Object>> employeesData = new ArrayList<>();
            for (Employee employee : employees) {
                Map<String, Object> employeeData = new HashMap<>();
                employeeData.put("name", employee.getEmpName());
                employeeData.put("amount", employee.getAmount());
                employeesData.add(employeeData);
            }
            Map<String, Object> currencyData = new HashMap<>();
            currencyData.put("currency", currency);
            currencyData.put("employees", employeesData);
            currencyDataList.add(currencyData);
        }
        // jsonResponse.put("errorMessage", "");
        jsonResponse.put("data", currencyDataList);

        return ResponseEntity.ok().body(jsonResponse);
    }
}