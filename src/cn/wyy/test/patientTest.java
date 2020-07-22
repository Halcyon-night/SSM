package cn.wyy.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wyy.pojo.Patient;
import cn.wyy.service.PatientService;

public class patientTest {
	// ClassPathXmlApplicationContext读取配置文件
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			// 使用getBean(),该方法的参数是ApplicationContext.xml的的bean的id值
			PatientService patientService = (PatientService) context.getBean("patientService");
	@Test
	public void test() {
		List<Patient> list = new ArrayList<Patient>();
		list =  patientService.getPatientList();
		for(Patient patient : list) {
			System.out.println(patient.getPatientDescribe());
		}
	}
}
