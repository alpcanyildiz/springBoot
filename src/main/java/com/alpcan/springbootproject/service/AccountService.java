package com.alpcan.springbootproject.service;

import com.alpcan.springbootproject.model.BankAccount;
import java.time.ZonedDateTime;
import java.util.List;

public interface AccountService {

    List<BankAccount> findByDateGreaterThanAndFromId (ZonedDateTime date, String fromId);
    List<BankAccount> findAll();
    public void saveAll(List<BankAccount> bankAccountList);

}
