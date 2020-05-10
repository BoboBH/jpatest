package com.bobo.one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bobo.one.dao.UserReportRepository;

import com.bobo.one.pojo.UserReport;
import com.mysql.cj.log.Log;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Service
public class UserReportService {
	
	@Autowired
	private UserReportRepository userReportRepository;
	
	public List<UserReport> getAllUserReport(){
		return userReportRepository.findAll();
	}
	
	public List<UserReport> search(String name, String schoolName, Integer startAge,
			Integer endAge){
		
		Specification<UserReport> spec = new Specification<UserReport>() 
		{
			@Override
			public Predicate toPredicate(Root<UserReport> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<>();
				if(!StringUtils.isEmpty(name)){
					Path<String> path = root.get("username");
					predicates.add(builder.like(path, name));
				}
				if(!StringUtils.isEmpty(schoolName)){
					Path<String> path = root.get("schoolName");
					predicates.add(builder.like(path.as(String.class), schoolName));
				}
				if(startAge != null){
					Path<Integer> path = root.get("age");
					predicates.add(builder.greaterThanOrEqualTo(path, startAge));						
				}
				if(endAge != null){
					Path<Integer> path = root.get("age");
					predicates.add(builder.lessThanOrEqualTo(path, endAge));						
				}
				Predicate[] p = new Predicate[predicates.size()];
				return builder.and(predicates.toArray(p));
			}  
		};
		return userReportRepository.findAll(spec);
	}

}
