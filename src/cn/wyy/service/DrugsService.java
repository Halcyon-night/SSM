package cn.wyy.service;

import java.util.List;


import cn.wyy.pojo.DrugDetails;
import cn.wyy.pojo.Drugs;

public interface DrugsService {
	/**
	 * 查询药品分类
	 * 
	 * @return
	 */
	public List<Drugs> getDrugsLisst();

	
	/**
	 * 信息回显
	 * @param drugDetailsId
	 * @return
	 */
	public DrugDetails getDrugDetailsList(Integer drugDetailsId);
	
	/**
	 * 下拉框展示数据
	 * @return
	 */
	public List<Drugs> getDrugsList();
	
	/**
	 * 对药品明细增加数据
	 * @param drugDetails
	 * @return
	 */
	public int addDrugDetails(DrugDetails drugDetails);
	
	/**
	 * 对药品明细修改数据
	 * @param drugDetails
	 * @return
	 */
	public int updateDrugDetails(DrugDetails drugDetails);
	
	/**
	 * 对药品明细进行删除
	 * @param drugDetailsId
	 * @return
	 */
	public int deleteDrugDetails(Integer drugDetailsId);
}
