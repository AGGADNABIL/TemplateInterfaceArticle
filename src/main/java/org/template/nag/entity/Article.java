package org.template.nag.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ART_PAR")
public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ART_KEYU")
	private Integer keyu ;
	@Column(name="ART_CODE")
	private String CodeArticle;
	@Column(name="ART_DESC")
	private String Designation;
	@Column(name="ART_DESL")
	private String DesignationLongue;
	@Column(name="TIE_CODE")
	private String CodeTiers;
	
	
	public Article() {
		
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

	public String getCodeTiers() {
		return CodeTiers;
	}

	public void setCodeTiers(String codeTiers) {
		CodeTiers = codeTiers;
	}

	public Integer getKeyu() {
		return keyu;
	}

	public void setKeyu(Integer keyu) {
		this.keyu = keyu;
	}

	public String getDesignationLongue() {
		return DesignationLongue;
	}

	public void setDesignationLongue(String designationLongue) {
		DesignationLongue = designationLongue;
	}

	public Article(String codeArticle, String designation, String designationLongue, String codeTiers) {
		super();
		CodeArticle = codeArticle;
		Designation = designation;
		DesignationLongue = designationLongue;
		CodeTiers = codeTiers;
	}

	@Override
	public String toString() {
		return "Article [CodeArticle=" + CodeArticle + ", Designation=" + Designation + ", DesignationLongue="
				+ DesignationLongue + ", CodeTiers=" + CodeTiers + "]";
	}

	
	
	
}
