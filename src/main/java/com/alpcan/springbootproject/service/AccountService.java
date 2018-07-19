package com.alpcan.springbootproject.service;

import com.alpcan.springbootproject.entity.BankAccountEntity;
import com.alpcan.springbootproject.model.BankAccount;

import java.util.Date;
import java.util.List;

public interface AccountService {

    List<BankAccount> findByDateGreaterThanAndFromId (Date date, String fromId);
    List<BankAccount> findAll();
    public void saveAll(List<BankAccount> bankAccountList);

}
