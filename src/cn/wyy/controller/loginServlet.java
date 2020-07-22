package cn.wyy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.wyy.pojo.Department;
import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Occupation;
import cn.wyy.pojo.Power;
import cn.wyy.service.DoctorService;

@Controller
public class loginServlet {
	@Autowired
	private DoctorService doctorService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "login";
	}

	/**
	 * 登录
	 * 
	 * @param doctorCode
	 * @param doctorPassword
	 * @return
	 */
	@RequestMapping("/dologin")
	public String login(String doctorCode, String doctorPassword, HttpSession session, HttpServletRequest request) {
		Doctor doctor = doctorService.getDoctorLogin(doctorCode, doctorPassword);
		if (null != doctor) {
			System.out.println(doctor.getDoctorCode());
			request.setAttribute("doctor_powerIdOne", 1);
			request.setAttribute("doctor_powerIdTow", 2);
			request.setAttribute("doctor_powerIdThree", 3);
			request.setAttribute("doctor_powerIdFour", 4);
			request.setAttribute("doctor_powerId", 2);
			session.setAttribute("doctor", doctor);
			return "home";
		} else {
			request.setAttribute("error", "用户名或密码不正确");
			return "login";
		}
		/* return "home"; */

	}

	/**
	 * 跳转到doctor.jsp页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/hrefdoctor")
	public ModelAndView doctor(int doctor_powerId, Model model, HttpServletRequest request) {
		List<Doctor> list = doctorService.getDoctorListBydoctor_powerId(doctor_powerId);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		model.addAttribute("doctorlist", list);
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("occupation", occupation);
		ModelAndView mav = new ModelAndView("/doctor");
		return mav;
	}
	
	/**
	 * 模糊查询医生
	 * @param doctor_powerId
	 * @param doctorName
	 * @param doctor_occupationId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/FuzzyqueryDoctor")
	public ModelAndView FuzzyqueryDoctor(int doctor_powerId,String doctorName,int doctor_occupationId, Model model, HttpServletRequest request) {
		List<Doctor> list = doctorService.FuzzyQueryDcotor(doctor_powerId, doctorName, doctor_occupationId);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		model.addAttribute("doctorlist", list);
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("occupation", occupation);
		ModelAndView mav = new ModelAndView("/doctor");
		return mav;
	}
	
	
	/**
	 * 跳转到nurse.jsp页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/hrefnurse")
	public ModelAndView nurse(int doctor_powerId, Model model, HttpServletRequest request) {
		List<Doctor> list = doctorService.getDoctorListBydoctor_powerId(doctor_powerId);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		model.addAttribute("nurselist", list);
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("occupation", occupation);
		ModelAndView mav = new ModelAndView("/nurse");
		return mav;
	}
	
	/**
	 * 模糊查询护士
	 * @param doctor_powerId
	 * @param doctorName
	 * @param doctor_occupationId
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/FuzzyqueryNurse")
	public ModelAndView FuzzyqueryNurse(int doctor_powerId,String doctorName,int doctor_occupationId, Model model, HttpServletRequest request) {
		List<Doctor> list = doctorService.FuzzyQueryDcotor(doctor_powerId, doctorName, doctor_occupationId);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		model.addAttribute("nurselist", list);
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("occupation", occupation);
		ModelAndView mav = new ModelAndView("/nurse");
		return mav;
	}

	/**
	 * 跳转到insertdoctor.jsp页面
	 * 
	 * @return
	 */
	@RequestMapping("/insertdoctor")
	public String insertdoctor(Model model,HttpServletRequest request) {
		List<Power> power = doctorService.getPowerList();
		List<Department> department = doctorService.getDepartmentList();
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("power", power);
		model.addAttribute("department", department);
		model.addAttribute("occupation", occupation);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		return "insertdoctor";
	}

	/**
	 * 跳转到insertnurse.jsp页面
	 * 
	 * @return
	 */
	@RequestMapping("/insertnurse")
	public String insertnurse(Model model,HttpServletRequest request) {
		List<Power> power = doctorService.getPowerList();
		List<Department> department = doctorService.getDepartmentList();
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("power", power);
		model.addAttribute("department", department);
		model.addAttribute("occupation", occupation);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		return "insertnurse";
	}

	/**
	 * 进行医生添加信息
	 * 
	 * @param doctor
	 * @return
	 */
	@RequestMapping("/addDoctor")
	public void insertDoctor(HttpServletResponse response, Doctor doctor, HttpServletRequest request) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = doctorService.addDoctor(doctor);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 进行护士添加信息
	 * 
	 * @param doctor
	 * @return
	 */
	@RequestMapping("/addNurse")
	public void insertNurse(HttpServletResponse response, Doctor doctor, HttpServletRequest request) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = doctorService.addDoctor(doctor);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 进行医生删除信息
	 * 
	 * @param id
	 */
	@RequestMapping("/deleteDoctor")
	public void deleteDoctor(HttpServletResponse response, Integer doctorId) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = doctorService.deleteDoctor(doctorId);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}

	
	/**
	 * 进行护士删除信息
	 * 
	 * @param id
	 */
	@RequestMapping("/deletenurse")
	public void deleteNurse(HttpServletResponse response, Integer doctorId) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = doctorService.deleteDoctor(doctorId);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 跳转到updatedoctor.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatedoctor")
	public String updatedoctor(Integer doctorId,Model model,HttpServletRequest request) {
		System.out.println(doctorId);
		List<Power> power = doctorService.getPowerList();
		List<Department> department = doctorService.getDepartmentList();
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("power", power);
		model.addAttribute("department", department);
		model.addAttribute("occupation", occupation);
		Doctor doctor = doctorService.echoDoctor(doctorId);
		model.addAttribute("doctor", doctor);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		return "updatedoctor";
	}
	
	/**
	 * 进行医生修改的方法
	 * @param response
	 * @param doctor
	 * @param request
	 */
	@RequestMapping("/updateDoctor")
	public void updateDoctor(HttpServletResponse response, Doctor doctor, HttpServletRequest request) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = doctorService.updateDoctor(doctor);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 跳转到updatenurse.jsp
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatenurse")
	public String updatenurse(Integer doctorId,Model model,HttpServletRequest request) {
		System.out.println(doctorId);
		List<Power> power = doctorService.getPowerList();
		List<Department> department = doctorService.getDepartmentList();
		List<Occupation> occupation = doctorService.getOccupationList();
		model.addAttribute("power", power);
		model.addAttribute("department", department);
		model.addAttribute("occupation", occupation);
		Doctor doctor = doctorService.echoDoctor(doctorId);
		model.addAttribute("doctor", doctor);
		request.setAttribute("doctor_powerIdOne", 1);
		request.setAttribute("doctor_powerIdTow", 2);
		request.setAttribute("doctor_powerIdThree", 3);
		request.setAttribute("doctor_powerIdFour", 4);
		return "updatenurse";
	}
	
	/**
	 * 进行护士修改的方法
	 * @param response
	 * @param doctor
	 * @param request
	 */
	@RequestMapping("/updateNurse")
	public void updateNurse(HttpServletResponse response, Doctor doctor, HttpServletRequest request) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = doctorService.updateDoctor(doctor);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}
	
}
