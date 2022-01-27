package com.lth.blog2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lth.blog2.model.User;

// DAO
// 자동으로 bean 등록이 된다.
// @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer>{

}
