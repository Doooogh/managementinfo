package com.graduation.info.managementinfo.info.testquestion.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-25 14:22:48
 */
public class TestQuestionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//试题名字
	private String tname;
	//本地地址
	private String url;
	//
	private String size;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //入参
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
	private Date createtime;
	//更新时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //入参
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
	private Date updatetime;
	//备用字段
	private Integer scId;

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
	 * 设置：试题名字
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
	/**
	 * 获取：试题名字
	 */
	public String getTname() {
		return tname;
	}
	/**
	 * 设置：本地地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：本地地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * 获取：
	 */
	public String getSize() {
		return size;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：备用字段
	 */
	public void setScId(Integer scId) {
		this.scId = scId;
	}
	/**
	 * 获取：备用字段
	 */
	public Integer getScId() {
		return scId;
	}
}
