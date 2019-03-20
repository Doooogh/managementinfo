package com.graduation.info.managementinfo.info.permission.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:54:33
 */
public class PermissionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//父id
	private Integer parentId;
	//权限描述
	private String name;
	//
	private String url;
	//
	private String permission;
	//
	private Integer sort;
	//类型
	private Integer type;
	//图标
	private String img;
	//创建时间
	private Date createtime;
	//修改时间
	private Date updatetime;

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
	 * 设置：父id
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父id
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：权限描述
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：权限描述
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	/**
	 * 获取：
	 */
	public String getPermission() {
		return permission;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：图标
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图标
	 */
	public String getImg() {
		return img;
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
}
