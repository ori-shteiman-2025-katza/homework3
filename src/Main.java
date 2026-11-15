//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args){
    BankAccount account1 = new BankAccount("ori",1200.0);
    BankAccount account2 = new BankAccount("tal",600.0);

    System.out.println("account1 id:"+ account1.getAccountId());
    System.out.println("account2 id:"+ account2.getAccountId());
    account1.deposit(500);
    account2.withdraw(200);
    account1.transferTo(account2,300.0);
    account1.withdraw(4000);
    System.out.println(account1.getBalance());
    account1.getAccountInfo();
    account2.getAccountInfo();
    System.out.println("total:" + BankAccount.getTotalAccounts());
    System.out.println("Next account ID: " + BankAccount.getNextAccountId());
    BankAccount acc3 = new BankAccount("David");
    System.out.println("New account ID: " + acc3.getAccountId());

    BankAccount acc1 = new BankAccount("noam", 500);
    boolean badDeposit = acc1.deposit(-50);
    boolean selfTransfer = acc1.transferTo(acc1, 100);
    System.out.println(""+badDeposit +" " +selfTransfer);
    Bank myBank = new Bank("Leumi", 10);
    myBank.setAccounts(acc1, acc3);
    System.out.println(myBank.getBankInfo());
    System.out.println("Total Balance: " + myBank.getTotalBalance());

}