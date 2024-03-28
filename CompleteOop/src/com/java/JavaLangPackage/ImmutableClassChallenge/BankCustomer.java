package com.java.JavaLangPackage.ImmutableClassChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private static int lastCustomerId = 10_000_000;
    private final String customerName;
    private final int customerId;
    private final List<BankAccount> accountList = new ArrayList<>();

    public BankCustomer(String customerName, double checkingAccount, double savingsAccount) {
        this.customerName = customerName;
        this.customerId = lastCustomerId++;
        accountList.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAccount));
        accountList.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingsAccount));
    }

    public String getCustomerName() {
        return customerName;
    }


    public List<BankAccount> getAccountList() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        String[] accountString = new String[accountList.size()];
        Arrays.setAll(accountString, i -> accountList.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(customerName, customerId,
                String.join("\n\t", accountString));
    }
}
