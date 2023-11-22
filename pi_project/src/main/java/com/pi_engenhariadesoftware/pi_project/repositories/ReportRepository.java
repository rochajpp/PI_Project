package com.pi_engenhariadesoftware.pi_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.pi_engenhariadesoftware.pi_project.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{

    @Query(value = "SELECT * FROM report", nativeQuery = true)
    public List<Report> getData();
}
