public class BankAccount {
    private int accountId;
    private String ownerName;
    private double balance;
    private boolean isActive;

    private static int nextId = 1000;
    private static int totalAccounts =0;

    public BankAccount(String ownerName) {
        this.accountId = nextId++;
        this.ownerName = ownerName;
        this.isActive = true;
        this.balance = 0.0;
        totalAccounts++;
    }

    public BankAccount(String ownerName, double initialBalance) {
        this.accountId = nextId++;
        this.ownerName = ownerName;
        this.isActive = true;
        totalAccounts++;
        if (initialBalance < 0) {
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    public boolean deposit(double amount) {
        if (!isActive || !isValidAmount(amount)) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (!isActive || !isValidAmount(amount) || balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount destination, double amount) {
        if (!isActive || destination == null || destination == this || !destination.isActive || !isValidAmount(amount) || balance < amount) {
            return false;
        }
        balance -= amount;
        destination.balance += amount;
        return true;
    }

    public boolean closeAccount() {
        if (!isActive || balance != 0) {
            return false;
        }
        isActive = false;
        return true;
    }

    public String getAccountInfo() {
        return "Account ID: " + accountId + ", Owner: " + ownerName + ", Balance: " + balance + ", Active: " + isActive;
    }
    public int getAccountId() {
        return accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public boolean setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.equals("")) {
            return false;
        }
        this.ownerName = ownerName;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public static int getNextAccountId() {
        return nextId;
    }
}
