package com.alpcan.springbootproject.service;

import com.alpcan.springbootproject.entity.BankAccount;

import java.util.Date;
import java.util.List;

public interface AccountService {

    List<BankAccount> findByDateGreaterThanAndFromID (Date date, String fromID);
    List<BankAccount> findAll();
    public void saveAll(List<BankAccount> bankAccountList);

}
