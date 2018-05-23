package com.spring.mvc.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dictionaryMetaData")
public class DictionarySearch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "URL")
	private String url;
	@Column(name = "TAG")
	private String tag;
	@Column(name = "UPDATEDATE")
	private Timestamp updateDate;

	public DictionarySearch(){
		
	}
	
	public DictionarySearch(int id, String title, String description, String url, String tag) {
		this.id= id;
		this.title = title;
		this.description = description;
		this.url = url;
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "TodoSearch [id=" + id + ", title=" + title + ", description=" + description + ", url=" + url + ", tag="
				+ tag + ", updateDate=" + updateDate + "]";
	}

}
