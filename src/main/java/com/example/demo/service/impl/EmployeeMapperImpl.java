package com.example.demo.service.impl;

import com.example.demo.dto.Bonus;
import com.example.demo.dto.Employee;
import com.example.demo.service.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeMapperImpl implements EmployeeMapper {


    @Override
    public Map<String, List<Employee>> map(List<Bonus> bonusList) {
        Map<String, List<Employee>> employeesByCurrency = new HashMap<>();

        bonusList.forEach(bonus -> {
            List<Employee> employeesForCurrency = employeesByCurrency.computeIfAbsent(
                    bonus.getCurrency(), k -> new ArrayList<>());

            Employee employee = new Employee();
            employee.setEmpName(bonus.getEmpName());
            employee.setAmount(bonus.getAmount());
            employeesForCurrency.add(employee);
        });

        employeesByCurrency.forEach((currency, employees) -> employees.sort(
                Comparator.comparing(Employee::getEmpName)));

        return employeesByCurrency;
    }

    public void test(){
        TreeSet<Employee> list = new TreeSet<>();
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        list.add(e1);
        list.add(e2);

    }
}
