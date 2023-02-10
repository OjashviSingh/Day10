class Account {
    String name;
    int balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void credit(int amount) {
        balance += amount;
        System.out.println(amount + " credited to the account of " + name);
    }

    public void debit(int amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
            System.out.println(amount + " debited from the account of " + name);
        }
    }
}

class AccountTest {
    public void testDebit() {
        Account account = new Account("John Doe", 1000);
        account.debit(100);
        assert account.balance == 900 : "Expected balance: 900, actual balance: " + account.balance;

        account.debit(1000);
        assert account.balance == 900 : "Expected balance: 900, actual balance: " + account.balance;
    }
}

public class Main {
    public static void main(String[] args) {
        AccountTest test = new AccountTest();
        test.testDebit();
    }
}