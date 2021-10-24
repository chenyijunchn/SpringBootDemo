package com.example.rediscurd.mapper;

import com.example.rediscurd.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into tb_user(user_name,password) values(#{name},#{password})")
    int addUser(@Param("name")String name,@Param("password")String password);

    @Select("select * from tb_user where user_id =#{id}")
    User findById(@Param("id") String id);

    @Update("update tb_user set user_name=#{name},password=#{password}  where user_id=#{id}")
  int updateById(User user);

    @Delete("delete from user where user_id=#{id}")
    void deleteById(@Param("id")String id);
}