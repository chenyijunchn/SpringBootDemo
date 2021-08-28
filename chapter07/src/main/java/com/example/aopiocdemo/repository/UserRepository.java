package com.example.aopiocdemo.repository;
import com.example.aopiocdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int user_id);
}
