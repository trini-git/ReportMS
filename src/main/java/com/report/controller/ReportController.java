package com.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.report.model.FixedTermVipModel;
import com.report.model.ReportModel;
import com.report.service.ReportService;

import reactor.core.publisher.Mono;

@RestController
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/find-by/{document}")
	public Mono<ReportModel> productsByDocument (@PathVariable String document){
		
		return reportService.productsByDocument(document);
		
	}
	
	@GetMapping("/find-by-ftv/{document}")
	public Mono<FixedTermVipModel> DocumentFtv (@PathVariable String document){
		
		return reportService.findDocumentFtv(document);
		
	}
	
	

}
