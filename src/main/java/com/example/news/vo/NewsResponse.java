package com.example.news.vo;

import java.util.List;

import com.example.news.entity.News;

public class NewsResponse {
	
	private String msg;
	
	private List<News> newsList;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public NewsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsResponse(String msg, List<News> newsList) {
		super();
		this.msg = msg;
		this.newsList = newsList;
	}
	
	

}
