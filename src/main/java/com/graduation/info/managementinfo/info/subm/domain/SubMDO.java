package com.graduation.info.managementinfo.info.subm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:45:43
 */
public class SubMDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学科id
	private Integer subId;
	//专业id
	private Integer mId;

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
	/**
	 * 设置：专业id
	 */
	public void setMId(Integer mId) {
		this.mId = mId;
	}
	/**
	 * 获取：专业id
	 */
	public Integer getMId() {
		return mId;
	}
}
