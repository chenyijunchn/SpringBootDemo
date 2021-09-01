package com.example.ormdemo.service.impl;

import com.example.ormdemo.entity.Article;
import com.example.ormdemo.repository.ArticleRepository;
import com.example.ormdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:ArticleServiceImpl
 * Author:Jane
 * Date:2021/8/3116:17
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {
@Autowired
    private ArticleRepository articleRepository;

@Override
    public List<Article> getArticleList(){
    return articleRepository.findAll();
}

@Override
public Article findArticleById(long id) {
    return articleRepository.findById(id);

}

@Override
    public Article findArticleByTitle(String title){
    return articleRepository.findByTitle(title);
}
}
