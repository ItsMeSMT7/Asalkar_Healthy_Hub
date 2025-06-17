package com.asalkar.healthyhub.controller;

import com.asalkar.healthyhub.model.Report;
import com.asalkar.healthyhub.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
@CrossOrigin(origins = "*") // to allow frontend to call backend
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @PostMapping
    public String submitReport(@RequestBody Report report) {
        reportRepository.save(report);
        return "Report submitted successfully!";
    }
}
