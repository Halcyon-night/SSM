package cn.wyy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wyy.pojo.DrugDetails;
import cn.wyy.pojo.Drugs;

public interface DrugsMapper {
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
	public DrugDetails getDrugDetailsList(@Param("drugDetailsId")Integer drugDetailsId);
	
	
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
	public int deleteDrugDetails(@Param("drugDetailsId")Integer drugDetailsId);
	
}
