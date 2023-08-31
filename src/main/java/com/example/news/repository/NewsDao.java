package com.example.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.news.entity.News;

public interface NewsDao extends JpaRepository<News, Integer>{

}
