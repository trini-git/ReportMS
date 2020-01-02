package com.report.service;

import com.report.model.ReportModel;

import reactor.core.publisher.Mono;

public interface IReportService {
	
	Mono<ReportModel> productsByDocument(String document);
	
}
