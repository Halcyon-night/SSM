package cn.wyy.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wyy.pojo.Doctor;
import cn.wyy.pojo.Occupation;
import cn.wyy.pojo.Power;
import cn.wyy.service.DoctorService;

public class doctorTest {
	public static void main(String[] args) {
		// ClassPathXmlApplicationContext读取配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 使用getBean(),该方法的参数是ApplicationContext.xml的的bean的id值
		DoctorService doctorService = (DoctorService) context.getBean("doctorService");
		String doctorCode = "admin";
		String doctorPassword = "123456";
		Doctor doctor = doctorService.getDoctorLogin(doctorCode, doctorPassword);
		System.out.println(doctor.getDoctorCode());
		System.out.println(doctor.getDoctorPassword());
		
		
		
		int doctor_powerId = 0;
		List<Doctor> doctorList=doctorService.getDoctorListBydoctor_powerId(doctor_powerId);
		for(Doctor d : doctorList ) {
			System.out.println(d.getDoctorName());
            Power p = d.getPower();
            System.out.println(p.getPowerName());
            
		}
	}
}
