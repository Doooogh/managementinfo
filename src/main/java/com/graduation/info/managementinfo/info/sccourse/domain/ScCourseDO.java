package com.graduation.info.managementinfo.info.sccourse.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:41:15
 */
public class ScCourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//学校id
	private Integer scId;
	//专业id
	private Integer mId;
	//备用字段
	private String ghghgh;
	//备用字段
	private String hghghg;

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
	 * 设置：备用字段
	 */
	public void setGhghgh(String ghghgh) {
		this.ghghgh = ghghgh;
	}
	/**
	 * 获取：备用字段
	 */
	public String getGhghgh() {
		return ghghgh;
	}
	/**
	 * 设置：备用字段
	 */
	public void setHghghg(String hghghg) {
		this.hghghg = hghghg;
	}
	/**
	 * 获取：备用字段
	 */
	public String getHghghg() {
		return hghghg;
	}
}
