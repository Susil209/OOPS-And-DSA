package external.util;

import com.java.JavaLangPackage.ImmutableClassChallenge.BankAccount;
import com.java.JavaLangPackage.ImmutableClassChallenge.BankCustomer;

import java.util.List;

public class MainImmutableChallenge {
    public static void main(String[] args) {
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 10000);
//        System.out.println(account);

        BankCustomer john = new BankCustomer("John",500.0, 12000.0);
        System.out.println(john);

        List<BankAccount> accounts = john.getAccountList();
//        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 1200000.00));
        accounts.clear();
        System.out.println(john);

    }
}
