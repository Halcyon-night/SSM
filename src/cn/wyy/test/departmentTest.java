package cn.wyy.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wyy.pojo.Department;
import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Occupation;
import cn.wyy.service.DepartmentService;


public class departmentTest {

	@Test
	public void test() {
		// ClassPathXmlApplicationContext读取配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 使用getBean(),该方法的参数是ApplicationContext.xml的的bean的id值
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		List<Department> list = new ArrayList<Department>();
		list = departmentService.getDepartmentList();
		for(Department department : list) {
			System.out.println("科室" + department.getDepartmentName());
			for(Doctor  doctor : department.getDoctorList()) {
				System.out.println("科室下的姓名:" + doctor.getDoctorName());
				for(Occupation occupation : department.getOccupationList()) {
					System.out.println("该姓名在医院的职业" + occupation.getOccupationName());
				}
			}
			
		}
	}
}
