package com.bobo.one.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bobo.one.pojo.UBser;

public interface UserRepository extends JpaRepository<UBser,Long>{

}
