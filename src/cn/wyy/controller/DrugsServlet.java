package cn.wyy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.wyy.pojo.DrugDetails;
import cn.wyy.pojo.Drugs;
import cn.wyy.service.DrugsService;

@Controller
public class DrugsServlet {
	@Autowired
	private DrugsService drugsService;

	public DrugsService getDrugsService() {
		return drugsService;
	}

	public void setDrugsService(DrugsService drugsService) {
		this.drugsService = drugsService;
	}

	/**
	 * 跳转到drugs.jsp页面
	 * 
	 * @return
	 */
	@RequestMapping("/hrefdrugs")
	public ModelAndView drugs(Model model) {
		List<Drugs> list = drugsService.getDrugsLisst();
		model.addAttribute("drugslist", list);
		ModelAndView mav = new ModelAndView("/drugs");
		return mav;
	}
	
	/**
	 * 跳转到drugDetails.jsp页面
	 * @param drugDetailsId
	 * @param model
	 * @return
	 */
	@RequestMapping("/hrefdrugdetails")
	public String drugdetails(Integer drugDetailsId,Model model) {
		System.out.println(drugDetailsId);
		DrugDetails drugdetails = drugsService.getDrugDetailsList(drugDetailsId);
		model.addAttribute("drugdetails", drugdetails);
		return "drugdetails";
	}
	
	/**
	 * 跳转到insertdrugdetails.jsp页面
	 * @return
	 */
	@RequestMapping("/insertdrugdetails")
	public String insertdrugdetails(Model model) {
		List<Drugs> durgslist = drugsService.getDrugsLisst();
		model.addAttribute("durgslist", durgslist);
		return "insertdrugdetails";
	}
	
	/**
	 * 进行药品明细添加信息
	 * @param response
	 * @param drugdetails
	 */
	@RequestMapping("/insertDrugDeails")
	public void insertDrugDetails(HttpServletResponse response,DrugDetails drugDetails) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = drugsService.addDrugDetails(drugDetails);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 跳转到updatedrugdetails.jsp
	 * @return
	 */
	@RequestMapping("/updatedrugdetails")
	public String upatedrugdetails(Integer drugDetailsId,Model model) {
		DrugDetails drugdetails = drugsService.getDrugDetailsList(drugDetailsId);
		model.addAttribute("drugdetails", drugdetails);
		List<Drugs> durgslist = drugsService.getDrugsLisst();
		model.addAttribute("durgslist", durgslist);
		return "updatedrugdetails";
	}
	
	/**
	 * 进行药品明细修改信息
	 * @param response
	 * @param drugDetails
	 */
	@RequestMapping("/updateDrugDetails")
	public void updateDrugDetails(HttpServletResponse response,DrugDetails drugDetails) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = drugsService.updateDrugDetails(drugDetails);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 删除药品明细信息
	 * @param response
	 * @param drugDetailsId
	 */
	@RequestMapping("/deleteDrugDetails")
	public void deleteDrugDetails(HttpServletResponse response,Integer drugDetailsId) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int row = drugsService.deleteDrugDetails(drugDetailsId);
		// 转换为JSON格式
		String str = "[{\"result\":\"" + row + "\"}]";
		out.print(str);
		out.flush();
		out.close();
		
	}

}
