package cn.wyy.dao;

import java.util.List;

import cn.wyy.pojo.Department;

public interface DepartmentMapper {
	
	/**
	 *     查询科室下的医生和医生的职业分类
	 *  @return
	 */
	public List<Department> getDepartmentList();
} 
