package com.akshay.repository;

import org.springframework.data.repository.CrudRepository;

import com.akshay.modal.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
