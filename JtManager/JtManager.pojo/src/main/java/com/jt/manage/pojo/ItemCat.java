package com.jt.manage.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;

@Table(name="tb_item_cat")//类和表的映射
public class ItemCat extends BasePojo{
	@Id //代表这是一个主键,自增字段
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Long id;//如何知道parent_id=parentId呢
	@Column(name="parent_id") //为什么只写了一个,这里做讲解实际上框架也给我们搞定了
	private Long parentId;//性能最高不要面向对象
	private String name;
	private Integer status;
	private Integer sortOrder;
	private Boolean isParent;
	
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}
