package com.graduation.info.managementinfo.info.sce.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-23 16:04:14
 */
public class ScEDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//学校id
	private Integer id;
	//
	private Integer scId;
	//招生简章id
	private Integer eId;

	/**
	 * 设置：学校id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：学校id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setScId(Integer scId) {
		this.scId = scId;
	}
	/**
	 * 获取：
	 */
	public Integer getScId() {
		return scId;
	}
	/**
	 * 设置：招生简章id
	 */
	public void setEId(Integer eId) {
		this.eId = eId;
	}
	/**
	 * 获取：招生简章id
	 */
	public Integer getEId() {
		return eId;
	}
}
