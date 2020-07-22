package cn.wyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wyy.dao.DepartmentMapper;
import cn.wyy.pojo.Department;
import cn.wyy.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	public DepartmentMapper getDepartmentMapper() {
		return departmentMapper;
	}



	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}



	@Override
	/**
	 * 首页页面信息显示
	 */
	public List<Department> getDepartmentList() {
		return departmentMapper.getDepartmentList();
	}

}
