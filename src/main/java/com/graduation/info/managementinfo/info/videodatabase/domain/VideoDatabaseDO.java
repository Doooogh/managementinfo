package com.graduation.info.managementinfo.info.videodatabase.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-26 15:01:05
 */
public class VideoDatabaseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//视频名称
	private String vname;
	//本地地址
	private String url;
	//大小
	private String size;
	//学校id
	private Integer scId;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //入参
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
	private Date createtime;
	//修改时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //入参
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //出参
	private Date updatetime;
	//备用字段
	private String hjhjhj;

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
	 * 设置：视频名称
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	/**
	 * 获取：视频名称
	 */
	public String getVname() {
		return vname;
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
	 * 设置：大小
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * 获取：大小
	 */
	public String getSize() {
		return size;
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
	 * 设置：修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：备用字段
	 */
	public void setHjhjhj(String hjhjhj) {
		this.hjhjhj = hjhjhj;
	}
	/**
	 * 获取：备用字段
	 */
	public String getHjhjhj() {
		return hjhjhj;
	}
}
