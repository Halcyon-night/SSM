package cn.wyy.pojo;

import java.util.Date;
import java.util.List;

public class Drugs {
	private int drugsId;
	private String drugsName;
	private Date drugsTime;
	private String drugsDescribe;
	
	private List<DrugDetails> drugDetailsList;				//一对多的形式关联数据
	public List<DrugDetails> getDrugDetailsList() {
		return drugDetailsList;
	}
	public void setDrugDetailsList(List<DrugDetails> drugDetailsList) {
		this.drugDetailsList = drugDetailsList;
	}
	
	
	
	
	
	public int getDrugsId() {
		return drugsId;
	}
	public void setDrugsId(int drugsId) {
		this.drugsId = drugsId;
	}
	public String getDrugsName() {
		return drugsName;
	}
	public void setDrugsName(String drugsName) {
		this.drugsName = drugsName;
	}
	public Date getDrugsTime() {
		return drugsTime;
	}
	public void setDrugsTime(Date drugsTime) {
		this.drugsTime = drugsTime;
	}
	public String getDrugsDescribe() {
		return drugsDescribe;
	}
	public void setDrugsDescribe(String drugsDescribe) {
		this.drugsDescribe = drugsDescribe;
	}
	
	
}
