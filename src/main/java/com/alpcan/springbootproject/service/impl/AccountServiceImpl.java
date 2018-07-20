package com.alpcan.springbootproject.service.impl;

import com.alpcan.springbootproject.model.BankAccount;
import com.alpcan.springbootproject.repository.AccountRepository;
import com.alpcan.springbootproject.entity.BankAccountEntity;
import com.alpcan.springbootproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<BankAccount> findByDateGreaterThanAndFromId(ZonedDateTime date, String fromId) {

        List<BankAccountEntity> bankAccountEntityList = accountRepository.findByDateGreaterThanAndFromId(date,fromId);


        List<BankAccount> bankAccountList = new ArrayList<BankAccount>();
        for (BankAccountEntity bankAccountEntity : bankAccountEntityList){

            BankAccount bankAccount = new BankAccount();

            bankAccount.setBalance(bankAccountEntity.getBalance());
            bankAccount.setDate(bankAccountEntity.getDate());
            bankAccount.setFromId(bankAccountEntity.getFromId());
            bankAccount.setToId(bankAccountEntity.getToId());

            bankAccount.setId(bankAccountEntity.getId());
            bankAccount.setFormattedDate(bankAccountEntity.getFormattedDate());
            bankAccountList.add(bankAccount);

        }
        return bankAccountList;
    }

    @Override
    public List<BankAccount> findAll() {
        List<BankAccountEntity> bankAccountEntityList = accountRepository.findAll();
        List<BankAccount> bankAccountList = new ArrayList<BankAccount>();

        for (BankAccountEntity bankAccountEntity : bankAccountEntityList){

            BankAccount bankAccount = new BankAccount();

            bankAccount.setId(bankAccountEntity.getId());
            bankAccount.setToId(bankAccountEntity.getToId());
            bankAccount.setFromId(bankAccountEntity.getFromId());
            bankAccount.setDate(bankAccountEntity.getDate());
            bankAccount.setBalance(bankAccountEntity.getBalance());
            bankAccount.setFormattedDate(bankAccountEntity.getFormattedDate());
            bankAccountList.add(bankAccount);

        }
        return bankAccountList;
    }

    @Override
    public void saveAll(List<BankAccount> bankAccountList) {

        List<BankAccountEntity> bankAccountEntityList = new ArrayList<BankAccountEntity>();

        for (BankAccount bankAccount : bankAccountList){


            BankAccountEntity bankAccountEntity = new BankAccountEntity();
            bankAccountEntity.setFromId(bankAccount.getFromId());
            bankAccountEntity.setBalance(bankAccount.getBalance());
            bankAccountEntity.setDate(bankAccount.getDate());
            bankAccountEntity.setFormattedDate(bankAccount.getFormattedDate());
            bankAccountEntity.setId(bankAccount.getId());
            bankAccountEntity.setToId(bankAccount.getToId());

            bankAccountEntityList.add(bankAccountEntity);

        }

        accountRepository.saveAll(bankAccountEntityList);
    }
}
