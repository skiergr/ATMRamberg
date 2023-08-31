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
}
