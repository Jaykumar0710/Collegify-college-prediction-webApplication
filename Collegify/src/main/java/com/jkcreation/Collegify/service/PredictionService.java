package com.jkcreation.Collegify.service;

import com.jkcreation.Collegify.entity.Cutoff;
import com.jkcreation.Collegify.repository.CutoffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PredictionService {

    @Autowired
    private CutoffRepository cutoffRepository;

    public List<Cutoff> predictColleges(BigDecimal percentile, String department, Cutoff.Category category) {
        BigDecimal minPercentile = percentile.subtract(BigDecimal.valueOf(5));
        BigDecimal maxPercentile = percentile.add(BigDecimal.valueOf(5));

        return cutoffRepository.findByDepartmentAndCategoryAndPercentileBetween(
                        department, category, minPercentile, maxPercentile)
                .stream()
                .sorted(Comparator.comparing(cutoff -> cutoff.getPercentile().subtract(percentile).abs()))
                .limit(10)
                .collect(Collectors.toList());


    }
}
