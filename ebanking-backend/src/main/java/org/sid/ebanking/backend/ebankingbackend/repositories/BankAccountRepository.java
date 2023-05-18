package org.sid.ebanking.backend.ebankingbackend.repositories;

import org.sid.ebanking.backend.ebankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}