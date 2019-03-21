package com.graduation.info.managementinfo.info.subject.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:54:21
 */
public class SubjectDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//
	private String name;
	//备用字段
	private String ababab;
	//备用字段
	private String bcbcbc;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：备用字段
	 */
	public void setAbabab(String ababab) {
		this.ababab = ababab;
	}
	/**
	 * 获取：备用字段
	 */
	public String getAbabab() {
		return ababab;
	}
	/**
	 * 设置：备用字段
	 */
	public void setBcbcbc(String bcbcbc) {
		this.bcbcbc = bcbcbc;
	}
	/**
	 * 获取：备用字段
	 */
	public String getBcbcbc() {
		return bcbcbc;
	}
}
