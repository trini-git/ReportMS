package com.report.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.report.model.CreditCardModel;
import com.report.model.FixedTermVipModel;
import com.report.model.ReportModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReportService implements IReportService {
	
	  @Autowired
	  @Qualifier("bankFixedTermAccountVip")
	  WebClient client;
	  
	  @Autowired
	  @Qualifier("creditCard")
	  WebClient client2;

	  FixedTermVipModel fixedTermVipModel = new FixedTermVipModel();
	  
	  CreditCardModel creditCardModel = new CreditCardModel();
	  
	  ReportModel reportModel = new ReportModel();
	
	  public Mono<FixedTermVipModel> findDocumentFtv(String document) {
		    Map<String, Object> param = new HashMap<String, Object>();
		    param.put("document", document);
		    return client.get()
		.uri("/find-by-document/{document}",param)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.retrieve()
		.bodyToMono(FixedTermVipModel.class)
		.switchIfEmpty(Mono.empty());
		  }
	  
	  public Mono<CreditCardModel> findDocumentCc(String document) {
		    Map<String, Object> param = new HashMap<String, Object>();
		    param.put("document", document);
		    return client2.get()
		.uri("/find-by-document/{document}",param)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.retrieve()
		.bodyToMono(CreditCardModel.class)
		.switchIfEmpty(Mono.empty());
		  }

	@Override
	public Mono<ReportModel> productsByDocument(String document) {
		
		return findDocumentFtv(document)
			.flatMap(a -> {
				
				fixedTermVipModel.setAccountNumber(a.getAccountNumber());
				
				return findDocumentCc(document)
								
			.flatMap(b ->{
				
				creditCardModel.setCreditCardNumber(b.getCreditCardNumber());
				
				reportModel.setFixedTermVipModel(fixedTermVipModel);
				reportModel.setCreditCardModel(creditCardModel);
				
				return Mono.just(reportModel);
			});
			});
		
	}
	  
	  

}
