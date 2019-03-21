package com.graduation.info.managementinfo.info.school.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:43:11
 */
public class SchoolDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//学校名字
	private String name;
	//招生简章
	private String enrollmentGuide;
	//试题库
	private String itemBank;
	//备用字段1
	private String aaaa;
	//备用字段2
	private String bbbb;
	//备用字段1
	private String cccc;
	//备用字段
	private String dddd;

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
	 * 设置：学校名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：学校名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：招生简章
	 */
	public void setEnrollmentGuide(String enrollmentGuide) {
		this.enrollmentGuide = enrollmentGuide;
	}
	/**
	 * 获取：招生简章
	 */
	public String getEnrollmentGuide() {
		return enrollmentGuide;
	}
	/**
	 * 设置：试题库
	 */
	public void setItemBank(String itemBank) {
		this.itemBank = itemBank;
	}
	/**
	 * 获取：试题库
	 */
	public String getItemBank() {
		return itemBank;
	}
	/**
	 * 设置：备用字段1
	 */
	public void setAaaa(String aaaa) {
		this.aaaa = aaaa;
	}
	/**
	 * 获取：备用字段1
	 */
	public String getAaaa() {
		return aaaa;
	}
	/**
	 * 设置：备用字段2
	 */
	public void setBbbb(String bbbb) {
		this.bbbb = bbbb;
	}
	/**
	 * 获取：备用字段2
	 */
	public String getBbbb() {
		return bbbb;
	}
	/**
	 * 设置：备用字段1
	 */
	public void setCccc(String cccc) {
		this.cccc = cccc;
	}
	/**
	 * 获取：备用字段1
	 */
	public String getCccc() {
		return cccc;
	}
	/**
	 * 设置：备用字段
	 */
	public void setDddd(String dddd) {
		this.dddd = dddd;
	}
	/**
	 * 获取：备用字段
	 */
	public String getDddd() {
		return dddd;
	}
}
