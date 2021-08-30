package com.example.ormdemo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * FileName:Article
 * Author:Jane
 * Date:2021/8/3017:06
 * Description:实例26 用JPA构建实体数据表
 */
@Entity
@Data
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    @NotEmpty(message="title cannot be null")
    private String title;

    @Column(columnDefinition = "enum('text','pict','all')")
    private String type;

    @Size(min=0,max=20)
    private String keyword;

    @Size(max=255)
    private String description;

    @Column(nullable = false)
    private String body;

    @Transient
    private List keywordlist;
    public List getKeywordlist() {
        return Arrays.asList(this.keyword.trim().split("|"));
    }
    public void setKeywordlists(List keywordlist){
        this.keywordlist=keywordlist;
    }
}
