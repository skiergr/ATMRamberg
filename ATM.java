import java.util.HashMap;

public class ATM {
    HashMap<String, Double> accountMap;

    public ATM() {
        accountMap = new HashMap<String, Double>();
    }

    public void openAccount(String userID, double amount) throws Exception {
        if (accountMap.containsKey(userID)) {
            throw new Exception("User already exists");
        } else {
            accountMap.put(userID, amount);
        }
    }
}
