package com.graduation.info.managementinfo.info.icon.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-28 12:59:27
 */
public class IconDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//名字
	private String name;
	//unicode字符
	private String code;
	//类名
	private String fontClass;

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
	 * 设置：unicode字符
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：unicode字符
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：类名
	 */
	public void setFontClass(String fontClass) {
		this.fontClass = fontClass;
	}
	/**
	 * 获取：类名
	 */
	public String getFontClass() {
		return fontClass;
	}
}
