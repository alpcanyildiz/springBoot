package com.alpcan.springbootproject.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class GetAccountsRequest {
    private String accountID;
    private String time;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
