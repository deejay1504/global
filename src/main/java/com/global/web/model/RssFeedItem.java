package com.global.web.model;

import java.util.Date;

public class RssFeedItem implements Comparable<RssFeedItem> {
	
	public RssFeedItem(String title, String description, String url, Date publishedDate) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.publishedDate = publishedDate;
	}

	private String title;

	private String description;
	
	private String url;
	
	private Date publishedDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(RssFeedItem obj) {
		return obj.getPublishedDate().compareTo(getPublishedDate());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[title = ");
		sb.append(title).append(", url = ").append(url)
		  .append(", description = ").append(description)
		  .append(", publishedDate = ").append(publishedDate.toString()).append("]");
		return sb.toString();
	}

}
