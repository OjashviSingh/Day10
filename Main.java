import java.util.*;

class Stock {
    String name;
    int shares;
    double price;

    public Stock(String name, int shares, double price) {
        this.name = name;
        this.shares = shares;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getShares() {
        return this.shares;
    }

    public double getPrice() {
        return this.price;
    }

    public double getValue() {
        return this.shares * this.price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Stock> stocks = new ArrayList<>();
        double totalValue = 0.0;

        System.out.print("Enter number of stocks: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter stock name: ");
            String name = scanner.nextLine();
            System.out.print("Enter number of shares: ");
            int shares = scanner.nextInt();
            System.out.print("Enter share price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Stock stock = new Stock(name, shares, price);
            stocks.add(stock);
            totalValue += stock.getValue();
        }

        System.out.println("Stock Report:");
        System.out.println("------------");
        for (Stock stock : stocks) {
            System.out.println("Name: " + stock.getName());
            System.out.println("Shares: " + stock.getShares());
            System.out.println("Price: " + stock.getPrice());
            System.out.println("Value: " + stock.getValue());
            System.out.println("--------------");
        }
        System.out.println("Total Value: " + totalValue);
    }
}
