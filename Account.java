public class Account {
        double balance;
    public Account( double balance){
            this.balance = balance;
        }
        public void debit ( double amount){
            if (amount > balance) {
                System.out.println("Debit amount exceeded account balance.");
            } else {
                balance -= amount;
            }
        }
        public double getBalance () {
            return balance;
        }
    }
class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(100.0);
        account.debit(50.0);
        System.out.println("Balance after debit: " + account.getBalance());

        account.debit(200.0);
        System.out.println("Balance after debit: " + account.getBalance());
    }
}
