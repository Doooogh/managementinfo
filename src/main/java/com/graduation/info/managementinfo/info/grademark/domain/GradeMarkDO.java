package com.graduation.info.managementinfo.info.grademark.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:50:04
 */
public class GradeMarkDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学校id
	private Integer scId;
	//专业id
	private Integer mId;
	//分数线
	private Integer grade;
	//备用字段
	private String year;
	//备用字段
	private String jljljl;

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
	/**
	 * 设置：分数线
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	/**
	 * 获取：分数线
	 */
	public Integer getGrade() {
		return grade;
	}
	/**
	 * 设置：备用字段
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：备用字段
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：备用字段
	 */
	public void setJljljl(String jljljl) {
		this.jljljl = jljljl;
	}
	/**
	 * 获取：备用字段
	 */
	public String getJljljl() {
		return jljljl;
	}
}
