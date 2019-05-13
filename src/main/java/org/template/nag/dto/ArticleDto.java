package org.template.nag.dto;

import javax.persistence.Column;

public class ArticleDto {

	private Integer keyu ;
	
	private String CodeArticle;
	
	private String Designation;
	
	private String DesignationLongue;
	
	private String CodeTiers;
	
	public ArticleDto() {
		
	}

	public ArticleDto(String codeArticle, String designation, String designationLongue, String codeTiers) {
		super();
		CodeArticle = codeArticle;
		Designation = designation;
		DesignationLongue = designationLongue;
		CodeTiers = codeTiers;
	}


	public Integer getKeyu() {
		return keyu;
	}

	public void setKeyu(Integer keyu) {
		this.keyu = keyu;
	}

	public String getCodeArticle() {
		return CodeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		CodeArticle = codeArticle;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getDesignationLongue() {
		return DesignationLongue;
	}

	public void setDesignationLongue(String designationLongue) {
		DesignationLongue = designationLongue;
	}

	public String getCodeTiers() {
		return CodeTiers;
	}

	public void setCodeTiers(String codeTiers) {
		CodeTiers = codeTiers;
	}
	
	
	
}
