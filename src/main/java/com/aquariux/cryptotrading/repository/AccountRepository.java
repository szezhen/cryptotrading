package com.aquariux.cryptotrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquariux.cryptotrading.domain.account.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
