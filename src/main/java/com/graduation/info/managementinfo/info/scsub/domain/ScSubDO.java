package com.graduation.info.managementinfo.info.scsub.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:36:41
 */
public class ScSubDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学校id
	private Integer scId;
	//学科id
	private Integer subId;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：学校id
	 */
	public void setScId(Integer scId) {
		this.scId = scId;
	}
	/**
	 * 获取：学校id
	 */
	public Integer getScId() {
		return scId;
	}
	/**
	 * 设置：学科id
	 */
	public void setSubId(Integer subId) {
		this.subId = subId;
	}
	/**
	 * 获取：学科id
	 */
	public Integer getSubId() {
		return subId;
	}
}
