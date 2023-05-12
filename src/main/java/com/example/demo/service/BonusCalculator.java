package com.example.demo.service;

import com.example.demo.dto.Bonus;
import com.example.demo.dto.Employee;

import java.util.List;
import java.util.Map;

public interface BonusCalculator {
    Map<String, List<Employee>> calculate(List<Bonus> bonuses);
}

