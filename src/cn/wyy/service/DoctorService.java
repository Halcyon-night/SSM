package cn.wyy.service;


import java.util.List;



import cn.wyy.pojo.Department;
import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Occupation;
import cn.wyy.pojo.Power;

public interface DoctorService {
	/**
	 * 登录
	 * @param doctorCode
	 * @param doctorPassword
	 * @return
	 */
	public Doctor getDoctorLogin(String doctorCode, String doctorPassword);
	
	/**
	 *   查询医生信息
	 * @return
	 */
	public List<Doctor> getDoctorListBydoctor_powerId(int doctor_powerId);
	
	/**
	 *     查询权限表信息
	 *  @return
	 */
	public List<Power> getPowerList();
	
	/**
	 *  查询科室表信息
	 * @return
	 */
	public List<Department> getDepartmentList();
	
	/**
	 * 查询职业表信息
	 * @return
	 */
	public List<Occupation> getOccupationList();
	
	/**
	 * 添加医生信息
	 * @param doctor
	 * @return
	 */
	public int addDoctor(Doctor doctor);
	
	
	/**
	 *   删除医生信息
	 * @param id
	 * @return
	 */
	public int deleteDoctor(Integer doctorId);
	
	/**
	 * 信息回显
	 * @param doctorId
	 * @return
	 */
	public Doctor echoDoctor(Integer doctorId);
	
	/**
	 *   修改医生信息
	 * @param doctor
	 * @return
	 */
	public int updateDoctor(Doctor doctor);
	
	
	/**
	 * 模糊查询医生信息
	 * @param doctor_powerId
	 * @return
	 */
	public List<Doctor> FuzzyQueryDcotor(Integer doctor_powerId,String  doctorName,Integer doctor_occupationId);
}
