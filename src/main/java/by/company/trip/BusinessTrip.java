package by.company.trip;


public class BusinessTrip {

    private String account;
    private final static int DAILY_ALLOWANCE_RATE = 15668;
    private int transportationExpenses;
    private int daysNumber;

    public BusinessTrip() {
    }

    public BusinessTrip(String account, int transportationExpenses, int daysNumber) {
        this.account = account;
        this.transportationExpenses = transportationExpenses;
        this.daysNumber = daysNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransportationExpenses() {
        return transportationExpenses;
    }

    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        this.daysNumber = daysNumber;
    }

    private static String convertToRubles(int value) {
        String result = value / 100 + "." + value % 100;
        if (value % 100 < 10) {
            return result + "0";
        } else {
            return result;
        }
    }

    public int getTotal() {
        return transportationExpenses + DAILY_ALLOWANCE_RATE * daysNumber;
    }

    public String show() {
        return "rate = " + convertToRubles(DAILY_ALLOWANCE_RATE) + "\n"
                + "account = " + account + "\n"
                + "transport = " + convertToRubles(transportationExpenses) + "\n"
                + "days = " + daysNumber + "\n"
                + "total = " + convertToRubles(getTotal()) + "\n";
    }

    public String toString() {
        return account + ";"
                + convertToRubles(transportationExpenses) + ";"
                + daysNumber + ";"
                + convertToRubles(getTotal());
    }
}
