package xy.study.self.atm.control;

import xy.study.self.atm.domain.Account;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-05-10 21:23
 * @desc:
 **/
public class Bank {
    private Account[] accounts = new Account[100];

    public Account[] getAccounts() {
        return this.accounts;
    }

    /**
     * 根据账号来验证该账号是否可用
     * @param name 被验证的账号
     * @return 如果可用返回true 否则false
     */
    public Account validateByName(String name) {
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null && accounts[i].getUsername().equals(name)) {
                return accounts[i];
            }
        }
        return null;
    }

    /**
     * 将开户的account对象存入银行
     * @param account
     * @return
     */
    public boolean save(Account account) {
        boolean flag = false;
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] == null) {
                accounts[i] = account;
                flag = true;
                break;
            }
        }
        return flag;
    }
}
