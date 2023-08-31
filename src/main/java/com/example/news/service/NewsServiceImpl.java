package com.example.news.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.news.constants.RtnCode;
import com.example.news.entity.News;
import com.example.news.repository.NewsDao;
import com.example.news.vo.NewsResponse;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsDao newsDao;

	
	private String getCurrentDate() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.format(currentDate);
	}
	
	@Override
	public NewsResponse getAllNews() {
		List<News> res = newsDao.findAll();
		Collections.reverse(res);
		
		if(res.size() == 0) {
			return new NewsResponse("目前沒有任何新聞！", null);
		}
		
		return new NewsResponse(RtnCode.SUCCESSFUL.getMsg(), res);
	}

	@Override
	public NewsResponse addNews(String title, String detail, String category) {
		
		if(!(StringUtils.hasText(title) && StringUtils.hasText(detail) && StringUtils.hasText(category))) {
			return new NewsResponse(RtnCode.DATA_ERROR.getMsg(), null);
		}

		String date = getCurrentDate();
	
		News news = new News(title, detail, category, date);
		newsDao.save(news);
		
		return new NewsResponse(RtnCode.SUCCESSFUL.getMsg(), new ArrayList<News>(Arrays.asList(news)));
	}

	@Override
	public NewsResponse getANews(int id) {
		
		if(id < 1 || !newsDao.existsById(id)) {
			return new NewsResponse(RtnCode.NOT_FOUNT.getMsg(), null);
		}
		
		Optional<News> res = newsDao.findById(id);
		News news = res.get();
		return new NewsResponse(RtnCode.SUCCESSFUL.getMsg(), new ArrayList<News>(Arrays.asList(news)));

		
	}

	@Override
	public NewsResponse editNews(int id, String detail) {
		
		if(!StringUtils.hasText(detail) || id < 1) {
			return new NewsResponse(RtnCode.DATA_ERROR.getMsg(), null);
		}
		if(!newsDao.existsById(id)) {
			return new NewsResponse(RtnCode.NOT_FOUNT.getMsg(), null);
		}
		
		Optional<News> res = newsDao.findById(id);
		News news = res.get();
		
		news.setDetail(detail);
		
		String date = getCurrentDate();
		
		news.setDate(date);//修改時將修改日期儲存
		newsDao.save(news);
		
		return new NewsResponse(RtnCode.SUCCESSFUL.getMsg(), new ArrayList<News>(Arrays.asList(news)));
		

	}

	@Override
	public NewsResponse deleteNews(int id) {
		if(id < 1 || !newsDao.existsById(id)) {
			return new NewsResponse(RtnCode.NOT_FOUNT.getMsg(), null);
		}
		
		newsDao.deleteById(id);
		return new NewsResponse(RtnCode.SUCCESSFUL.getMsg(), null);
	}
	

}
