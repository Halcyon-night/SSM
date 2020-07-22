package cn.wyy.pojo;

import java.util.Date;
import java.util.List;

public class Department {
	private int departmentId;
	private String departmentName;
	private Date departmentTime;
	private String departmentDescribe;
	
	
	private List<Doctor> doctorList;				//一对多--医生信息表
	private List<Occupation> OccupationList;		//一对多--职业分类信息表
	public List<Doctor> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	public List<Occupation> getOccupationList() {
		return OccupationList;
	}
	public void setOccupationList(List<Occupation> occupationList) {
		OccupationList = occupationList;
	}
	
	
	
	
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getDepartmentTime() {
		return departmentTime;
	}
	public void setDepartmentTime(Date departmentTime) {
		this.departmentTime = departmentTime;
	}
	public String getDepartmentDescribe() {
		return departmentDescribe;
	}
	public void setDepartmentDescribe(String departmentDescribe) {
		this.departmentDescribe = departmentDescribe;
	}
	
	
}
