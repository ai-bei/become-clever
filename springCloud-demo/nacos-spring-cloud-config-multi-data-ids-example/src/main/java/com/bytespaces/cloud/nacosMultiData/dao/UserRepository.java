package com.bytespaces.cloud.nacosMultiData.dao;


import com.bytespaces.cloud.nacosMultiData.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}