package com.piggymetrics.auth.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.piggymetrics.auth.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, ObjectId> {
    Optional<UserInfo> findByName(String username);

}