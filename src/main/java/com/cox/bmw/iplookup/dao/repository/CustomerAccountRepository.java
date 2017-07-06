package com.cox.bmw.iplookup.dao.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cox.bmw.iplookup.dao.model.CustomerAccountInfo;

@EnableScan
public interface CustomerAccountRepository extends CrudRepository<CustomerAccountInfo, String> {
	List<CustomerAccountInfo> findById(String id);
	
	List<CustomerAccountInfo> findByipaddress(String ipAddress);
}
