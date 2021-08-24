package com.example.mvcdemo.model;

import com.example.mvcdemo.MyConstraint;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
/**
 * FileName:User
 * Author:Jane
 * Date:2021/8/2411:15
 * Description:User Entity
 */
@Data
public class User implements Serializable {
    private long id;

    @NotBlank(message="user name cannot be null")
    @Length(min=1,max=20)
    private String name;

    @NotNull(message="age cannot be null")
    @Min(value = 0)
    @Max(value = 120)
    private int age;

    @MyConstraint
    private String answer;
}
