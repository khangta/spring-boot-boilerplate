package com.example.springbootboilerplate.user.persistence.repository;

import com.example.springbootboilerplate.user.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserQuerydslRepository {

}
