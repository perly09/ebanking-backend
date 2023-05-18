package org.sid.ebanking.backend.ebankingbackend.services;

import org.sid.ebanking.backend.ebankingbackend.dtos.*;
import org.sid.ebanking.backend.ebankingbackend.entities.BankAccount;
import org.sid.ebanking.backend.ebankingbackend.entities.CurrentAccount;
import org.sid.ebanking.backend.ebankingbackend.entities.Customer;
import org.sid.ebanking.backend.ebankingbackend.entities.SavingAccount;
import org.sid.ebanking.backend.ebankingbackend.exceptions.BalanceNotSufficientException;
import org.sid.ebanking.backend.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.sid.ebanking.backend.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
