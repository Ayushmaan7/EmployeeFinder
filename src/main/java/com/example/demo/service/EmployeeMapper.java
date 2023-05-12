package com.example.demo.service;

import com.example.demo.dto.Bonus;
import com.example.demo.dto.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
 //   Map<String, List<Employee>> map(Map<String, List<Employee>> activeEmp);

    Map<String, List<Employee>> map(List<Bonus> bonusList);
}

