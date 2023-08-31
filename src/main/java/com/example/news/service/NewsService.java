package com.example.news.service;

import java.util.List;

import com.example.news.entity.News;
import com.example.news.vo.NewsResponse;

public interface NewsService {
	
	public NewsResponse getAllNews();
	
	public NewsResponse getANews(int id);
	
	public NewsResponse addNews(String title, String detail, String category);
	
	public NewsResponse editNews(int id, String detail);
	
	public NewsResponse deleteNews(int id);
}
