import java.io.FileWriter;
import java.util.HashMap;

public class ATM {
    HashMap<String, Double> accountMap;

    public ATM() {
        accountMap = new HashMap<String, Double>();
    }

    public void openAccount(String userID, double amount) throws Exception {
        if (accountMap.containsKey(userID)) {
            throw new Exception("User already exists.");
        } else {
            accountMap.put(userID, amount);
        }
    }

    public void closeAccount(String userID) throws Exception {
        if (accountMap.containsKey(userID)) {
            if (accountMap.get(userID) == 0) {
                accountMap.remove(userID);
            } else {
                throw new Exception("Withdraw before closing account.");
            }
        } else {
            throw new Exception("User does not exist.");
        }
    }

    public double checkBalance(String userID) throws Exception {
        if (accountMap.containsKey(userID)) {
            return accountMap.get(userID);
        } else {
            throw new Exception("User does not exist.");
        }
    }

    public double depositMoney(String userID, double amount) throws Exception {
        if (accountMap.containsKey(userID)) {
            accountMap.put(userID, accountMap.get(userID) + amount);
            return amount;
        } else {
            throw new Exception("User does not exist.");
        }
    }

    public double withdrawMoney(String userID, double amount) throws Exception {
        if (accountMap.containsKey(userID)) {
            if (accountMap.get(userID) >= amount) {
                accountMap.put(userID, accountMap.get(userID) - amount);
                return amount;
            } else {
                throw new Exception("You are broke loser.");
            }
        } else {
            throw new Exception("User does not exist.");
        }
    }

    public boolean transferMoney(String fromAccount, String toAccount, double amount) {
        if (accountMap.containsKey(fromAccount) && accountMap.containsKey(toAccount)) {
            if (accountMap.get(fromAccount) >= amount) {
                accountMap.put(fromAccount, accountMap.get(fromAccount) - amount);
                accountMap.put(toAccount, accountMap.get(toAccount) + amount);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void audit() throws Exception {
        FileWriter writer = new FileWriter("AccountAudit.txt");
        for (String userID : accountMap.keySet()) {
            writer.write(userID + "\n");
            writer.write(Double.toString(accountMap.get(userID)) + "\n");
        }
        writer.close();
    }
}
