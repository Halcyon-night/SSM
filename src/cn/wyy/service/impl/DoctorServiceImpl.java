package cn.wyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.wyy.dao.DoctorMapper;
import cn.wyy.pojo.Department;
import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Occupation;
import cn.wyy.pojo.Power;
import cn.wyy.service.DoctorService;
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorMapper doctorMapper;
	
	
	public DoctorMapper getDoctorMapper() {
		return doctorMapper;
	}


	public void setDoctorMapper(DoctorMapper doctorMapper) {
		this.doctorMapper = doctorMapper;
	}


	@Override
	/**
	 *  登录
	 */
	public Doctor getDoctorLogin(String doctorCode, String doctorPassword) {
		return doctorMapper.getDoctorLogin(doctorCode, doctorPassword);
	}


	@Override
	/**
	 *  查询出医生的信息
	 */
	public List<Doctor> getDoctorListBydoctor_powerId(int doctor_powerId) {
		return doctorMapper.getDoctorListBydoctor_powerId(doctor_powerId);
	}


	@Override
	/**
	 * 查询权限表
	 */
	public List<Power> getPowerList() {
		return doctorMapper.getPowerList();
	}


	@Override
	/**
	 * 查询科室表
	 */
	public List<Department> getDepartmentList() {
		return doctorMapper.getDepartmentList();
	}


	@Override
	/**
	 * 查询职业表
	 */
	public List<Occupation> getOccupationList() {
		return doctorMapper.getOccupationList();
	}


	@Override
	/**
	 * 添加一条医生信息
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int addDoctor(Doctor doctor) {
		return doctorMapper.addDoctor(doctor);
	}


	@Override
	/**
	 * 删除一条医生信息
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteDoctor(Integer doctorId) {
		return doctorMapper.deleteDoctor(doctorId);
	}


	@Override
	/**
	 * 信息回显
	 */
	public Doctor echoDoctor(Integer doctorId) {
		return doctorMapper.echoDoctor(doctorId);
	}


	@Override
	/**
	 * 修改一条医生信息
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateDoctor(Doctor doctor) {
		return doctorMapper.updateDoctor(doctor);
	}


	@Override
	/**
	 * 模糊查询医生
	 */
	public List<Doctor> FuzzyQueryDcotor(Integer doctor_powerId, String doctorName, Integer doctor_occupationId) {
		return doctorMapper.FuzzyQueryDcotor(doctor_powerId, doctorName, doctor_occupationId);
	}

}
