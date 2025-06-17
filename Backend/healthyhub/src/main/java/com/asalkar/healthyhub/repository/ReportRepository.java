package com.asalkar.healthyhub.repository;

import com.asalkar.healthyhub.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
