import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class CompanyShares {
    String symbol;
    int shares;
    double price;
    LocalDateTime dateTime;

    public CompanyShares(String symbol, int shares, double price) {
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.dateTime = LocalDateTime.now();
    }
}

public class StockAccount {
    List<CompanyShares> sharesList;

    public StockAccount() {
        sharesList = new ArrayList<CompanyShares>();
    }

    public void addCompanyShares(String symbol, int shares, double price) {
        CompanyShares cs = new CompanyShares(symbol, shares, price);
        sharesList.add(cs);
    }

    public double valueOf() {
        double value = 0;
        for (CompanyShares cs : sharesList) {
            value += cs.shares * cs.price;
        }
        return value;
    }

    public void buy(String symbol, int shares, double price) {
        CompanyShares cs = getCompanyShares(symbol);
        if (cs != null) {
            cs.shares += shares;
            cs.price = price;
            cs.dateTime = LocalDateTime.now();
        } else {
            addCompanyShares(symbol, shares, price);
        }
    }

    public void sell(String symbol, int shares, double price) {
        CompanyShares cs = getCompanyShares(symbol);
        if (cs != null) {
            cs.shares -= shares;
            cs.price = price;
            cs.dateTime = LocalDateTime.now();
        } else {
            addCompanyShares(symbol, -shares, price);
        }
    }

    public void displayStockReport() {
        System.out.println("Stock Report:");
        for (CompanyShares cs : sharesList) {
            System.out.println("Symbol: " + cs.symbol + ", Shares: " + cs.shares + ", Price: " + cs.price + ", Value: " + (cs.shares * cs.price));
        }
    }

    public CompanyShares getCompanyShares(String symbol) {
        for (CompanyShares cs : sharesList) {
            if (cs.symbol.equals(symbol)) {
                return cs;
            }
        }
        return null;
    }
}
