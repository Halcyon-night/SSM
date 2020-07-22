package cn.wyy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Patient;
import cn.wyy.service.PatientService;

@Controller
public class PatientServlet {
	@Autowired
	private PatientService patientService;

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	/**
	 * 跳转到patient.jsp页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/hrefpatient")
	public ModelAndView patient(Integer doctor_powerId,Model model, HttpServletRequest request) {
		List<Patient> list = patientService.getPatientList();
		List<Doctor> doctorlist = patientService.getDoctorList(doctor_powerId);
		model.addAttribute("patientlist", list);
		model.addAttribute("doctor_powerId", 2);
		model.addAttribute("doctorlist", doctorlist);
		ModelAndView mav = new ModelAndView("/patient");
		return mav;
	}

	/**
	 * 模糊查询
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/FuzzyQueryPatient")
	public ModelAndView FuzzyQueryPatient(Integer doctor_powerId, String patientName, Integer patient_doctorId,Model model, HttpServletRequest request) {
		List<Doctor> doctorlist = patientService.getDoctorList(doctor_powerId);
		List<Patient> list = patientService.FuzzyQuery(patientName, patient_doctorId);
		model.addAttribute("patientlist", list);
		model.addAttribute("doctor_powerId", 2);
		model.addAttribute("doctorlist", doctorlist);
		ModelAndView mav = new ModelAndView("/patient");
		return mav;
	}
	
	
	
	/**
	 * 跳转到insertpatient.jsp页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertpatient")
	public String insertPatient(Integer doctor_powerId, Model model, HttpServletRequest request) {
		List<Doctor> doctorlist = patientService.getDoctorList(doctor_powerId);
		model.addAttribute("doctorlist", doctorlist);
		return "insertpatient";
	}

	/**
	 * 对病人进行数据添加
	 * 
	 * @param response
	 * @param patient
	 */
	@RequestMapping("/insertPatient")
	public void insertpatient(HttpServletResponse response, Patient patient) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = patientService.addPatient(patient);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 跳转到updatepatient.jsp页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatepatient")
	public String updatepatient(Integer patientId, Model model, Integer doctor_powerId) {
		List<Doctor> doctorlist = patientService.getDoctorList(doctor_powerId);
		Patient patient = patientService.echoPatient(patientId);
		model.addAttribute("doctorlist", doctorlist);
		model.addAttribute("patient", patient);
		return "updatepatient";
	}

	/**
	 * 对病人进行数修改
	 * 
	 * @param response
	 * @param patient
	 */
	@RequestMapping("/updatePatient")
	public void updatePatient(HttpServletResponse response, Patient patient) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = patientService.updatePatient(patient);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}

	
	/**
	 * 对病人信息进行删除
	 * @param response
	 * @param patientId
	 */
	@RequestMapping("/deletePatient")
	public void deletePatient(HttpServletResponse response, Integer patientId) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = patientService.deletePatient(patientId);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}

}
