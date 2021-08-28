package com.example.aopiocdemo.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


/**
 * FileName:User
 * Author:Jane
 * Date:2021/8/2711:27
 * Description:
 */
@Entity
@Table(name = "tb_user")
@Data
@Setter
@Getter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
}
