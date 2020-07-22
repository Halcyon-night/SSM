package cn.wyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Patient;

public interface PatientMapper {
	
	/**
	 *  查询病人信息
	 *  @return
	 */
	public List<Patient> getPatientList();
	
	/**
	 *   模糊查询
	 * @param patientName
	 * @param patient_doctorId
	 * @return
	 */
	public List<Patient> FuzzyQuery(@Param("patientName")String patientName,@Param("patient_doctorId")Integer patient_doctorId);
	
	/**
	 * 查询医生信息,下拉列表框展示信息
	 * @return
	 */
	public List<Doctor> getDoctorList(@Param("doctor_powerId")Integer doctor_powerId);
	
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
	public Patient echoPatient(@Param("patientId")Integer patientId);
	
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
	public int deletePatient(@Param("patientId")Integer patientId);
}
