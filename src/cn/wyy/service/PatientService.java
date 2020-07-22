package cn.wyy.service;

import java.util.List;


import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Patient;

public interface PatientService {
	
	/**
	 * 查询病人信息
	 * @return
	 */
	public List<Patient> getPatientList();
	
	
	/**
	 *   模糊查询
	 * @param patientName
	 * @param patient_doctorId
	 * @return
	 */
	public List<Patient> FuzzyQuery(String patientName,Integer patient_doctorId);
	
	/**
	 * 查询医生信息,下拉列表框展示信息
	 * @return
	 */
	public List<Doctor> getDoctorList(Integer doctor_powerId);
	
	/**
	 * 增加病人信息
	 * @param patient
	 * @return
	 */
	public int addPatient(Patient patient);
	
	
	
	/**
	 * 信息回显,助于修改
	 * @param patientId
	 * @return
	 */
	public Patient echoPatient(Integer patientId);
	
	/**
	 * 修改病人信息
	 * @param patient
	 * @return
	 */
	public int updatePatient(Patient patient);
	
	/**
	 * 删除病人信息
	 * @param patientId
	 * @return
	 */
	public int deletePatient(Integer patientId);
}
