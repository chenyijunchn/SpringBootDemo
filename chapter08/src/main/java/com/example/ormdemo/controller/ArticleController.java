package com.example.ormdemo.controller;

import com.example.ormdemo.entity.Article;
import com.example.ormdemo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName:ArticleController
 * Author:Jane
 * Date:2021/8/3116:20
 * Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Description: 文章列表
     */
    @RequestMapping("")
    public ModelAndView articlelist(@RequestParam(value = "start",defaultValue = "0") Integer start,
                                    @RequestParam(value = "limit",defaultValue = "5")Integer limit){
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        ModelAndView mav = new ModelAndView("article/list");
        mav.addObject("page", page);
        return mav;
    }

    /**
     * Description: 根据id获取文章对象
     */
    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable("id") Integer id)  throws Exception {
        Article articles = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", articles);
        return mav;
    }

    /**
     * Description: 根据title获取文章对象
     * 不加/s/无法区分和getbyid的路径
     */
    @GetMapping("/s/{title}")
    public ModelAndView getArticle(@PathVariable("title") String title)  throws Exception {
        Article articles = articleRepository.findByTitle(title);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", articles);
        return mav;
    }

    /**
     * Description: 新增操作视图
     */
    @GetMapping("/add")
    public String addArticle()   throws Exception{
        return "article/add";
    }

    /**
     * Description: 新增保存方法
     */
    @PostMapping("")
    public String saveArticle(Article model)  throws Exception{
        articleRepository.save(model);
        return "redirect:article";
    }

    /**
     * Description: 删除
     */
    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") long id)  throws Exception{
        articleRepository.deleteById(id);
        return "redirect:";
    }


    /**
     * Description: 编辑视图
     */
    @GetMapping("/edit/{id}")
    public ModelAndView editArticle(@PathVariable("id") long id)  throws Exception {
        Article model = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/edit");
        mav.addObject("article", model);
        return mav;
    }

    /**
     * Description: 修改方法
     */
    @PutMapping("/{id}")
    public String editArticleSave(Article model, long id)  throws Exception{
        model.setId(id);
        articleRepository.save(model);
        return "redirect:";
    }

}
