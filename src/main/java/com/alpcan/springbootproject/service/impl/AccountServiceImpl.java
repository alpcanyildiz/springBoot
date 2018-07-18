package com.alpcan.springbootproject.service.impl;

import com.alpcan.springbootproject.dao.AccountDao;
import com.alpcan.springbootproject.entity.BankAccount;
import com.alpcan.springbootproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;
    @Override
    public List<BankAccount> findByDateGreaterThanAndFromID(Date date, String fromID) {
        return accountDao.findByDateGreaterThanAndFromID(date,fromID);
    }

    @Override
    public List<BankAccount> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void saveAll(List<BankAccount> bankAccountList) {
        accountDao.saveAll(bankAccountList);
    }
}
