package com.example.ormdemo.repository;

import com.example.ormdemo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * FileName:ArticleRepository
 * Author:Jane
 * Date:2021/8/3116:11
 * Description:
 */
public interface ArticleRepository extends JpaRepository<Article,Long> , JpaSpecificationExecutor<Article> {
Article findById(long id);
Article findByTitle(String title);
}
