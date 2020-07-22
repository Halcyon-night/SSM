package cn.wyy.pojo;

public class Doctor {
	private int doctorId;
	private String doctorCode;
	private String doctorName;
	private String doctorPassword;
	private int doctorSex;
	private String doctorAddress;
	private int doctor_powerId;
	private int doctor_occupationId;
	private int doctor_departmentId;
	
	//一对一的形式
	private Power power;					//用户权限角色
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	
	//一对一的形式
	private Occupation occupation;
	public Occupation getOccupation() {
		return occupation;
	}
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	
	//一对一的形式
	private Department department;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorCode() {
		return doctorCode;
	}
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	public int getDoctorSex() {
		return doctorSex;
	}
	public void setDoctorSex(int doctorSex) {
		this.doctorSex = doctorSex;
	}
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public int getDoctor_powerId() {
		return doctor_powerId;
	}
	public void setDoctor_powerId(int doctor_powerId) {
		this.doctor_powerId = doctor_powerId;
	}
	public int getDoctor_occupationId() {
		return doctor_occupationId;
	}
	public void setDoctor_occupationId(int doctor_occupationId) {
		this.doctor_occupationId = doctor_occupationId;
	}
	public int getDoctor_departmentId() {
		return doctor_departmentId;
	}
	public void setDoctor_departmentId(int doctor_departmentId) {
		this.doctor_departmentId = doctor_departmentId;
	}
	
	
	
}
