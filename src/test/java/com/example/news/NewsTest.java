package com.example.news;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.news.repository.NewsDao;
import com.example.news.service.NewsService;
import com.example.news.vo.NewsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = NewsApplication.class)
public class NewsTest {

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private NewsDao newsDao;
	
	@Test
	public void getAllNewsTest() {
		NewsResponse res = newsService.getAllNews();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String resStr = objectMapper.writeValueAsString(res);
			System.out.println(resStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addNewsTest() {
		NewsResponse res = newsService.addNews("標題3", "內文3", "其他");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String resStr = objectMapper.writeValueAsString(res);
			System.out.println(resStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getANewsTest() {
		NewsResponse res = newsService.getANews(2);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String resStr = objectMapper.writeValueAsString(res);
			System.out.println(resStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void editNewsTest() {
		NewsResponse res = newsService.editNews(4, "修改後的內文");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String resStr = objectMapper.writeValueAsString(res);
			System.out.println(resStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteNewsTest() {
		NewsResponse res = newsService.deleteNews(3);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String resStr = objectMapper.writeValueAsString(res);
			System.out.println(resStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
