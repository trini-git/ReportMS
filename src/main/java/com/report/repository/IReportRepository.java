package com.report.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.report.model.ReportModel;

@Repository
public interface IReportRepository extends ReactiveMongoRepository<ReportModel, String>{

}
