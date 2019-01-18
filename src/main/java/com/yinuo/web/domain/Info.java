package com.yinuo.web.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.yinuo.common.annotation.ExportConfig;

@Table(name = "t_info")
public class Info implements Serializable {

	private static final long serialVersionUID = 7163741045226037981L;

	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "INFO_ID")
	private Long infoId;

	@Column(name = "NAME")
	@ExportConfig(value = "名称")
	private String name;

	@Column(name = "CONTENT")
	@ExportConfig(value = "内容")
	private String content;

	@Column(name = "INTO_TYPE")
	private String infoType;

	@Transient
	@ExportConfig(value = "分类名称")
	private String infoTypeName;

	@Column(name = "CRATE_TIME")
	@ExportConfig(value = "创建时间", convert = "c:com.yinuo.common.util.poi.convert.TimeConvert")
	private Date crateTime;

	@Column(name = "MODIFY_TIME")
	private Date modifyTime;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getInfoTypeName() {
		return infoTypeName;
	}

	public void setInfoTypeName(String infoTypeName) {
		this.infoTypeName = infoTypeName;
	}

	public Date getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public Long getAuthCacheKey() {
		return infoId;
	}
}