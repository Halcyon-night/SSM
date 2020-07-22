package cn.wyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.wyy.dao.PatientMapper;
import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Patient;
import cn.wyy.service.PatientService;
@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientMapper patientMapper;
	
	
	public PatientMapper getPatientMapper() {
		return patientMapper;
	}


	public void setPatientMapper(PatientMapper patientMapper) {
		this.patientMapper = patientMapper;
	}


	@Override
	/**
	 * 查询病人信息
	 */
	public List<Patient> getPatientList() {
		return patientMapper.getPatientList();
	}


	@Override
	/**
	 * 查询医生信息,展示下拉列表框的数据
	 */
	public List<Doctor> getDoctorList(Integer doctor_powerId) {
		return patientMapper.getDoctorList(doctor_powerId);
	}


	@Override
	/**
	 * 添加医生信息
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int addPatient(Patient patient) {
		return patientMapper.addPatient(patient);
	}


	@Override
	/**
	 * 信息回显
	 */
	public Patient echoPatient(Integer patientId) {
		return patientMapper.echoPatient(patientId);
	}


	@Override
	/**
	 * 修改病人信息
	 */
	public int updatePatient(Patient patient) {
		return patientMapper.updatePatient(patient);
	}


	@Override
	/**
	 * 删除病人信息
	 */
	public int deletePatient(Integer patientId) {
		return patientMapper.deletePatient(patientId);
	}


	@Override
	/**
	 * 模糊查询病人信息
	 */
	public List<Patient> FuzzyQuery(String patientName, Integer patient_doctorId) {
		return patientMapper.FuzzyQuery(patientName, patient_doctorId);
	}

}
