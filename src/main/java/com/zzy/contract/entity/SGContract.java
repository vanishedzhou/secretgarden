package com.zzy.contract.entity;

import java.io.Serializable;
import java.util.Date;

public class SGContract implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3570943645255866713L;

	private int id;
	private String content;
	private Date updated_at;
	private int updated_by;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	@Override
	public String toString() {
		return "content=" + content + " updated_at=" + updated_at;
	}
}
