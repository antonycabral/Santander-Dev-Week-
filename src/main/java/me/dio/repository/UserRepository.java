package me.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
