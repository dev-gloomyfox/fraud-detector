package com.gloomyfox.domain.dto;

public class RuleADTO {
    private int count;
    private long balance;

    public RuleADTO(int count, long balance) {
        this.count = count;
        this.balance = balance;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    public long getBalance() {
        return balance;
    }
}
