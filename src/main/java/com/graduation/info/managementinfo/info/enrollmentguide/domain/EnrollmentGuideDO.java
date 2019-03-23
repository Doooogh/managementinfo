package com.graduation.info.managementinfo.info.enrollmentguide.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-23 16:10:21
 */
public class EnrollmentGuideDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//文件路径
	private String url;
	//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //入参
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
	private Date createtime;
	//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //入参
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
	private Date updatetime;
	//备用字段
	private String pooppoo;

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
	 * 设置：文件路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：文件路径
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：备用字段
	 */
	public void setPooppoo(String pooppoo) {
		this.pooppoo = pooppoo;
	}
	/**
	 * 获取：备用字段
	 */
	public String getPooppoo() {
		return pooppoo;
	}
}
