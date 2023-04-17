package com.example.firstDemo.Repository;

import com.example.firstDemo.Models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {


    List<Mark> findAll();
}
