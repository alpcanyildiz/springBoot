package com.alpcan.springbootproject.dao;

import com.alpcan.springbootproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends JpaRepository<User,Long> {




}
