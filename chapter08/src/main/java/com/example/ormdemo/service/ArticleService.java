package com.example.ormdemo.service;

import com.example.ormdemo.entity.Article;

import java.util.List;

/**
 * FileName:ArticleService
 * Author:Jane
 * Date:2021/8/3116:15
 * Description:
 */
public interface ArticleService {
    public List<Article> getArticleList();
    public Article findArticleById(long id);
    public Article findArticleByTitle(String title);
}
