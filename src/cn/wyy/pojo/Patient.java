package cn.wyy.pojo;

public class Patient {
	private int patientId;
	private String patientName;
	private int patientSex;
	private int patientAge;
	private String patientDescribe;
	private int patient_doctorId;
	private int patient_drugsId;
	private int patient_drugDetailsId;
	
	
	
	//一对一的形式
	private Doctor doctor;
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(int patientSex) {
		this.patientSex = patientSex;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientDescribe() {
		return patientDescribe;
	}
	public void setPatientDescribe(String patientDescribe) {
		this.patientDescribe = patientDescribe;
	}
	public int getPatient_doctorId() {
		return patient_doctorId;
	}
	public void setPatient_doctorId(int patient_doctorId) {
		this.patient_doctorId = patient_doctorId;
	}
	public int getPatient_drugsId() {
		return patient_drugsId;
	}
	public void setPatient_drugsId(int patient_drugsId) {
		this.patient_drugsId = patient_drugsId;
	}
	public int getPatient_drugDetailsId() {
		return patient_drugDetailsId;
	}
	public void setPatient_drugDetailsId(int patient_drugDetailsId) {
		this.patient_drugDetailsId = patient_drugDetailsId;
	}
	
	
}
