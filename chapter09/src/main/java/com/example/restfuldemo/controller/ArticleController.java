package com.example.restfuldemo.controller;

import com.example.restfuldemo.entity.Article;
import com.example.restfuldemo.repository.ArticleRepository;
import com.example.restfuldemo.result.ExceptionMsg;
import com.example.restfuldemo.result.Response;
import com.example.restfuldemo.result.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Author:   longzhonghua
 * Date:     3/24/2019 9:22 AM
 * Description: ${DESCRIPTION}
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @ApiOperation(value="getlist",notes = "getList")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseData  getArticleList() {
        List<Article> list = new ArrayList<Article>(articleRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,list);

    }

    //增
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseData add(@RequestBody Article article) {
        articleRepository.save(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }


    //删
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") long id) {
        articleRepository.deleteById(id);
        return result(ExceptionMsg.SUCCESS);
      }


    //改
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseData update(@RequestBody Article model) {
        articleRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS,model);
    }

    //查
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData findArticle(@PathVariable("id") Integer id) throws IOException {
              Article article = articleRepository.findById(id);
        if (article != null) {
            return new ResponseData(ExceptionMsg.SUCCESS,article);
        }
        return new ResponseData(ExceptionMsg.FAILED,article);
    }
    //查
    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/re/{id}", method = RequestMethod.GET)
    public Article findArticled(@PathVariable("id") Integer id) throws IOException {
        RestTemplate client= restTemplateBuilder.build();
        String uri = "http://localhost:8080/article/"+id;
        System.out.println(uri);
        Article article = client.getForObject (uri,Article.class,id) ;

        return article;
    }
}


