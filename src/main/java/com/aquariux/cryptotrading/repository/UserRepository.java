package com.aquariux.cryptotrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquariux.cryptotrading.domain.general.User;

public interface UserRepository extends JpaRepository<User, String> {

}
