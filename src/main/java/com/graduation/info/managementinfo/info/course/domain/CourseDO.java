package com.graduation.info.managementinfo.info.course.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:47:45
 */
public class CourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//课程id
	private Integer id;
	//名字
	private String name;
	//课程地址
	private String url;
	//课程大小
	private String size;
	//备用字段
	private String oioioi;
	//备用字段
	private String ioioio;

	/**
	 * 设置：课程id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：课程id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：课程地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：课程地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：课程大小
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * 获取：课程大小
	 */
	public String getSize() {
		return size;
	}
	/**
	 * 设置：备用字段
	 */
	public void setOioioi(String oioioi) {
		this.oioioi = oioioi;
	}
	/**
	 * 获取：备用字段
	 */
	public String getOioioi() {
		return oioioi;
	}
	/**
	 * 设置：备用字段
	 */
	public void setIoioio(String ioioio) {
		this.ioioio = ioioio;
	}
	/**
	 * 获取：备用字段
	 */
	public String getIoioio() {
		return ioioio;
	}
}
