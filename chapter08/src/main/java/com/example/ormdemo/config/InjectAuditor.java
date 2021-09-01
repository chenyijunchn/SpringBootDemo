/*
package com.example.ormdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context;
import java.util.Optional;

/**
 * FileName:InjectAuditor
 * Author:Jane
 * Date:2021/9/116:49
 * Description:给bean中的@CreateBy @LastModifiedBy注入操作人

@Configuration
public class InjectAuditor implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor(){
        SecurityContext securityContext=SecurityContextHolder.getContext();
        if(securityContext==null){
            return null;
        }
        if (securityContext.getAuthentication()==null){
            return null;
        }else {
            String loginUserName=securityContext.getName();
            Optional<String> name= Optional.ofNullable(loginUserName);
            return name;
        }
    }

}
*/