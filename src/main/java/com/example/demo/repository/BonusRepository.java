package com.example.demo.repository;

import com.example.demo.dto.Bonus;
import com.example.demo.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {
}


