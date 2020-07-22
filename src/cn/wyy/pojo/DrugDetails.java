package cn.wyy.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class DrugDetails {
	private int drugDetailsId;
	private String drugDetailsName;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date drugDetailsTime;
	
	private String drugDetailsDescribe;
	private int drugDetails_DrugsId;
	public int getDrugDetailsId() {
		return drugDetailsId;
	}
	public void setDrugDetailsId(int drugDetailsId) {
		this.drugDetailsId = drugDetailsId;
	}
	public String getDrugDetailsName() {
		return drugDetailsName;
	}
	public void setDrugDetailsName(String drugDetailsName) {
		this.drugDetailsName = drugDetailsName;
	}
	public Date getDrugDetailsTime() {
		return drugDetailsTime;
	}
	public void setDrugDetailsTime(Date drugDetailsTime) {
		this.drugDetailsTime = drugDetailsTime;
	}
	public String getDrugDetailsDescribe() {
		return drugDetailsDescribe;
	}
	public void setDrugDetailsDescribe(String drugDetailsDescribe) {
		this.drugDetailsDescribe = drugDetailsDescribe;
	}
	public int getDrugDetails_DrugsId() {
		return drugDetails_DrugsId;
	}
	public void setDrugDetails_DrugsId(int drugDetails_DrugsId) {
		this.drugDetails_DrugsId = drugDetails_DrugsId;
	}
	
	
}
