package cn.wyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wyy.dao.DrugsMapper;
import cn.wyy.pojo.DrugDetails;
import cn.wyy.pojo.Drugs;
import cn.wyy.service.DrugsService;

@Service("drugsService")
public class DrugsServiceImpl implements DrugsService {
	@Autowired
	private DrugsMapper drugsMapper;

	public DrugsMapper getDrugsMapper() {
		return drugsMapper;
	}

	public void setDrugsMapper(DrugsMapper drugsMapper) {
		this.drugsMapper = drugsMapper;
	}

	@Override
	/**
	 * 查询药品分类信息
	 */
	public List<Drugs> getDrugsLisst() {
		return drugsMapper.getDrugsLisst();
	}

	@Override
	/**
	 * 信息回显
	 */
	public DrugDetails getDrugDetailsList(Integer drugDetailsId) {
		return drugsMapper.getDrugDetailsList(drugDetailsId);
	}

	@Override
	/**
	 * 查询药品分类,展示下拉框的信息
	 */
	public List<Drugs> getDrugsList() {
		return drugsMapper.getDrugsLisst();
	}

	@Override
	/**
	 * 增加药品明细信息
	 */
	public int addDrugDetails(DrugDetails drugDetails) {
		return drugsMapper.addDrugDetails(drugDetails);
	}

	@Override
	/**
	 * 修改药品明细信息
	 */
	public int updateDrugDetails(DrugDetails drugDetails) {
		return drugsMapper.updateDrugDetails(drugDetails);
	}

	@Override
	/**
	 * 对药品明细进行删除
	 */
	public int deleteDrugDetails(Integer drugDetailsId) {
		return drugsMapper.deleteDrugDetails(drugDetailsId);
	}

}
