package com.example.demo.service.impl;

import com.example.demo.dto.Bonus;
import com.example.demo.dto.Employee;
import com.example.demo.repository.BonusRepository;
import com.example.demo.service.BonusCalculator;
import com.example.demo.service.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BonusCalculatorImpl implements BonusCalculator {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private BonusRepository bonusRepository;
//
//    @Autowired
//    public BonusCalculatorImpl(EmployeeMapper employeeMapper) {
//        this.employeeMapper = employeeMapper;
//    }

    @Override
    public Map<String, List<Employee>> calculate(List<Bonus> bonusList) {
        //saving into db
        try{
            bonusRepository.saveAll(bonusList);
        }catch(Exception ex){
            System.out.println("Error Saving Data:" + ex);
        }

        LocalDate today = LocalDate.now();

        List<Bonus> activeEmployees = bonusList.stream()
                .filter(bonus -> ( bonus.getExitDate().isAfter(today))
                        && bonus.getJoiningDate().isBefore(today))
                .collect(Collectors.toList());

        // Call the employee mapper service to map employees to currency and sort them by name
        Map<String, List<Employee>> employeesByCurrencySortedByName = employeeMapper.map(activeEmployees);

        return employeesByCurrencySortedByName;
    }


}
