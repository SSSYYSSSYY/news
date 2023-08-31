package com.example.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.news.constants.RtnCode;
import com.example.news.entity.News;
import com.example.news.service.NewsService;
import com.example.news.vo.NewsResponse;


@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;

	//首頁
    @GetMapping("/news")
	public String hello(Model model) {
    	
    	String controllerTest = "controllerTest";
    	
    	NewsResponse res = newsService.getAllNews();
    	
    	model.addAttribute("controllerTest", controllerTest);
    	model.addAttribute("newsList", res.getNewsList());//res裡面有兩個屬性1.msg 2.一個裝有新聞資訊的List
    	
		return "news";
	}
    
    //進入新增頁面
    @GetMapping("/add_news")
    public String addNewsPage() {
        return "add_news";
    }
    
    //對新增頁面發送POST請求，新增新聞到資料庫
    @PostMapping("/add_news")
    public String addNews(@RequestParam String title, @RequestParam String detail, @RequestParam String category) {
        NewsResponse res = newsService.addNews(title, detail, category);
        
        if (res.getMsg() == RtnCode.SUCCESSFUL.getMsg()) {
            return "redirect:/news";
        } else {
            return "error_page";
        }
    }

    
    //查看特定新聞的頁面
    @GetMapping("/news/{id}")
    public String viewNews(@PathVariable int id, Model model) {
        NewsResponse res = newsService.getANews(id);
        
        if (res.getMsg() == RtnCode.SUCCESSFUL.getMsg()) {
        	model.addAttribute("currentNews", res.getNewsList().get(0));
        	return "view_news";
        } else {
            return "error_page";
        }  
    }
    
    //查看特定新聞的編輯畫面
    @GetMapping("/edit_news/{id}")
    public String viewEditPage(@PathVariable int id, Model model) {
        NewsResponse res = newsService.getANews(id);

        model.addAttribute("currentNews", res.getNewsList().get(0));
        
        return "edit_news";
    }
    
    //對特定新聞進行編輯
    @PostMapping("/edit_news/{id}")
    public String editNews(@PathVariable int id, @RequestParam String detail) {
        NewsResponse res = newsService.editNews(id, detail);

//      model.addAttribute("currentNews", res.getNewsList().get(0));
        
        if (res.getMsg() == RtnCode.SUCCESSFUL.getMsg()) {
            return "redirect:/news/{id}";
        } else {
            return "error_page";
        }
    }
    
    //錯誤頁面
    @GetMapping("/*")
    public String errorPage(@PathVariable int id, Model model) {
        return "error_page";
    }

}
