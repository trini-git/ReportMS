package com.report.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")
public class ReportModel {
	
	FixedTermVipModel fixedTermVipModel;
	CreditCardModel creditCardModel;
	
	public FixedTermVipModel getFixedTermVipModel() {
		return fixedTermVipModel;
	}
	public void setFixedTermVipModel(FixedTermVipModel fixedTermVipModel) {
		this.fixedTermVipModel = fixedTermVipModel;
	}
	public CreditCardModel getCreditCardModel() {
		return creditCardModel;
	}
	public void setCreditCardModel(CreditCardModel creditCardModel) {
		this.creditCardModel = creditCardModel;
	}
	
	
	
	
}
