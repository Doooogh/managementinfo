package com.graduation.info.managementinfo.info.major.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:52:03
 */
public class MajorDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//专业名字
	private String name;
	//备用字段
	private String cdcdcd;
	//备用字段
	private String dedede;

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
	 * 设置：专业名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：专业名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：备用字段
	 */
	public void setCdcdcd(String cdcdcd) {
		this.cdcdcd = cdcdcd;
	}
	/**
	 * 获取：备用字段
	 */
	public String getCdcdcd() {
		return cdcdcd;
	}
	/**
	 * 设置：备用字段
	 */
	public void setDedede(String dedede) {
		this.dedede = dedede;
	}
	/**
	 * 获取：备用字段
	 */
	public String getDedede() {
		return dedede;
	}
}
