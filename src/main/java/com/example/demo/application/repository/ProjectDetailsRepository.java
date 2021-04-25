package com.example.demo.application.repository;

import com.example.demo.application.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDetailsRepository extends JpaRepository<Project,Long>{}
