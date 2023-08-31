public class ATMMain {
    public static void main(String[] args) throws Exception {
        ATM atm = new ATM();
        atm.openAccount("account1", 10);
        atm.openAccount("account2", 15);
        atm.openAccount("account3", 20);
        atm.audit();
        atm.withdrawMoney("account2", 15);
        atm.depositMoney("account1", 10);
        atm.audit();
        atm.closeAccount("account2");
        atm.audit();
        System.out.println(atm.checkBalance("account1"));
        System.out.println(atm.transferMoney("account1", "account3", 15));
        atm.audit();
    }
}