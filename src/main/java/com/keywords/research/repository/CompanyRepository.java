package com.keywords.research.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keywords.research.entity.Companies;

@Repository
public interface CompanyRepository extends JpaRepository<Companies, Integer>{

}
