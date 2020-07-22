package cn.wyy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.wyy.pojo.Department;
import cn.wyy.service.DepartmentService;

@Controller
public class DepartmentServlet {
	@Autowired
	private DepartmentService departmentService;
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	/**
	 *   跳转到welcome.jsp页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/welcome")
	public ModelAndView welcome(Model model) {
		List<Department> list = departmentService.getDepartmentList();
		model.addAttribute("list",list);
		ModelAndView mav = new ModelAndView("/welcome");
		return mav;
	}
	
}
