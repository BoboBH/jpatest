package com.bobo.one.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bobo.one.pojo.UserReport;

public interface UserReportRepository extends JpaRepository<UserReport, Long>,
				JpaSpecificationExecutor<UserReport>{

}
