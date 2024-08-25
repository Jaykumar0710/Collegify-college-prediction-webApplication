package com.jkcreation.Collegify.repository;

import com.jkcreation.Collegify.entity.Cutoff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CutoffRepository extends JpaRepository<Cutoff, Long> {
    List<Cutoff> findByDepartmentAndCategoryAndPercentileBetween(
            String department, Cutoff.Category category, BigDecimal minPercentile, BigDecimal maxPercentile);
}
