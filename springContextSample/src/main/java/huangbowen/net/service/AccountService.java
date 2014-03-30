package huangbowen.net.service;

import java.util.Map;

public class AccountService {

    private Map<String,Integer> accounts;


    public Map<String, Integer> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Integer> accounts) {
        this.accounts = accounts;
    }
}
