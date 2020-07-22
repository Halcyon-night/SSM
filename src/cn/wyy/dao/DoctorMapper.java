package cn.wyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wyy.pojo.Department;
import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Occupation;
import cn.wyy.pojo.Power;

public interface DoctorMapper {
	
	/**
	 *   登录
	 * @param doctorCode
	 * @param doctorPassword
	 * @return
	 */
	public Doctor getDoctorLogin(@Param("doctorCode")String doctorCode, @Param("doctorPassword")String doctorPassword);
	
	
	/**
	 * 查询医生信息
	 * @return
	 */
	public List<Doctor> getDoctorListBydoctor_powerId(@Param("doctor_powerId") int doctor_powerId);
	
	
	/**
	 *  查询权限表信息
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
	public int deleteDoctor(@Param("doctorId") Integer doctorId);
	
	
	
	/**
	 * 信息回显
	 * @param doctorId
	 * @return
	 */
	public Doctor echoDoctor(@Param("doctorId")Integer doctorId);
	
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
	public List<Doctor> FuzzyQueryDcotor(@Param("doctor_powerId")Integer doctor_powerId, @Param("doctorName")String  doctorName,@Param("doctor_occupationId")Integer doctor_occupationId);
	
}
