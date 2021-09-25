package com.example.restfuldemo.service;


import com.example.restfuldemo.entity.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> getArticleList();
    public  Article findArticleById(long id);

}
