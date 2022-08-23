package com.aquariux.cryptotrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquariux.cryptotrading.domain.general.Symbol;

public interface SymbolRepository extends JpaRepository<Symbol, String> {

}
