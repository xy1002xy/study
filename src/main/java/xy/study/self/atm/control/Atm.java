package xy.study.self.atm.control;

import xy.study.self.atm.domain.Account;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-05-10 21:22
 * @desc:
 **/
public class Atm {
    private java.util.Scanner input = new java.util.Scanner(System.in);
    private Bank bank = new Bank();
    Account account=new Account();
    /**
     * ATM启动方法
     */
    public void start() {
        System.out.println("-----------------------");
        System.out.println("3. 开户");
      //  System.out.println("2. 插卡");
        System.out.println("1. 登录系统");
        System.out.println("2. 退出");
        System.out.println("-----------------------");

        System.out.println("请选择菜单项：");

        String index = input.next();

        if("1".equals(index)) {
            login();
        } //else if("2".equals(index)) {
           // login();
       // }
        else if("3".equals(index)) {
            createAccount();
        }
        else if("2".equals(index)) {
            System.out.println("谢谢您的使用");
            System.exit(0);
        }// else {
          //  System.out.println("输入错误");
            start();
       // }
    }

    /**
     * 管理员登录
     */
    private void adminLogin() {
        System.out.println("请输入管理员密码：");
        String password = input.next();

        if("000000".equals(password)) {
            showAdminMenu();
        } else {
            System.out.println("密码错误");
            start();
        }

    }

    /**
     * 显示管理员登录后的菜单
     */
    private void showAdminMenu() {
        System.out.println("------------------------------");
        System.out.println("1. 显示所有账户");
        System.out.println("2. 冻结账户");
        System.out.println("3. 恢复账户");
        System.out.println("4. 退出");
        System.out.println("------------------------------");

        System.out.println("请选择菜单项：");

        String index = input.next();

        if("1".equals(index)) {
            showAllAccount();
        } else if("2".equals(index)) {
            disableAccount();
        } else if("3".equals(index)) {
            enableAccount();
        } else if("4".equals(index)) {
            start();
        } else {
            System.out.println("输入错误");
            showAdminMenu();
        }
    }

    /**
     * 恢复账户
     */
    private void enableAccount() {
        Account[] accounts = bank.getAccounts();

        System.out.println("账户名\t\t\t是否可用");
        System.out.println("-----------------------------");
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null && !accounts[i].isEnable()) {
                System.out.println(accounts[i].getUsername() + "\t\t\t" + (accounts[i].isEnable() ? "√" : "X"));
            }
        }

        System.out.println("请输入被恢复的账户名称：");
        String name = input.next();

        Account a = bank.validateByName(name);
        if(a == null) {
            System.out.println("该账户不存在");
        } else {
            a.setEnable(true);
            System.out.println("恢复成功");
        }
        showAdminMenu();
    }

    /**
     * 冻结账号
     */
    private void disableAccount() {
        Account[] accounts = bank.getAccounts();

        System.out.println("账户名\t\t\t是否可用");
        System.out.println("-----------------------------");
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null && accounts[i].isEnable()) {
                System.out.println(accounts[i].getUsername() + "\t\t\t" + (accounts[i].isEnable() ? "√" : "X"));
            }
        }

        System.out.println("请输入被冻结的账户名称：");
        String name = input.next();

        Account a = bank.validateByName(name);
        if(a == null) {
            System.out.println("该账户不存在");
        } else {
            a.setEnable(false);
            System.out.println("冻结成功");
        }
        showAdminMenu();
    }

    /**
     * 显示所有账户
     */
    private void showAllAccount() {
        Account[] accounts = bank.getAccounts();

        System.out.println("账户名\t\t\t是否可用");
        System.out.println("-----------------------------");
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null) {
                System.out.println(accounts[i].getUsername() + "\t\t\t" + (accounts[i].isEnable() ? "√" : "X"));
            }
        }
        showAdminMenu();
    }

    /**
     * 账号登录
     */
    private void login() {
        System.out.println("请输入账号：");
        String username = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        int count=5;
        //根据用户名和密码来验证是否允许登陆
        Account account = bank.validateByName(username);
        do {
            if(account != null && account.getPassword().equals(password)) {
                if(account.isEnable()) {
                    System.out.println("欢迎你," + account.getUsername());
                    showAccountMenu(account);
                }
            }else {
                count--;
                System.out.println("对不起，您好输入的密码不正确，请重新输入，您还有"+count+"次机会");
                System.out.println("请输入密码：");
                password = input.next();
            }} while (count>1);
                System.out.println("累计密码5次，系统被迫退出");
                System.exit(0);



    }

    private void showAccountMenu(Account a) {
        System.out.println("---------------------------");
        System.out.println("1. 查询余额");
        System.out.println("2. 存款");
        System.out.println("3. 取款");
        System.out.println("4. 转账");
        System.out.println("5. 修改密码");
        System.out.println("6. 退出");
        System.out.println("---------------------------");
        System.out.println("请选择菜单项：");
        String index = input.next();

        if("1".equals(index)) {
            showAccountMoney(a);
        } else if("2".equals(index)) {
            saveMoney(a);
        } else if("3".equals(index)) {
            getMoney(a);
        } else if("4".equals(index)) {
            tranMoney(a);
        } else if("5".equals(index)) {
            editPassword(a);
        } else if("6".equals(index)) {
            start();
        } else {
            System.out.println("输入错误");
            showAccountMenu(a);
        }

    }

    private void tranMoney(Account a) {
        System.out.println("请输入转入方账号：");
        String inName = input.next();

        Account inAccount = bank.validateByName(inName);
        if(inAccount == null) {
            System.out.println("转入方账号错误");
        } else {
            if(inAccount.isEnable()) {

                boolean flag = false;
                do{
                    System.out.println("请输入转账金额：");
                    double money = input.nextDouble();

                    if(money <= 0) {
                        System.out.println("金额输入错误");
                        flag = true;
                    } else {
                        if(a.getMoney() < money) {
                            System.out.println("余额不足");
                        } else {
                            a.setMoney(a.getMoney() - money);
                            inAccount.setMoney(inAccount.getMoney() + money);
                            flag = false;
                            System.out.println("转账成功");
                        }
                    }
                }while(flag);
            } else {
                System.out.println("转入方账号不可用");
            }
        }
        showAccountMenu(a);
    }

    /**
     * 修改密码
     * @param a
     */
    private void editPassword(Account a) {
        System.out.println("请输入原始密码：");
        String oldPassword = input.next();

        if(a.getPassword().equals(oldPassword)) {
            boolean flag = false;
            do{
                System.out.println("请输入新密码：");
                String password = input.next();

                System.out.println("请确认新密码：");
                String repassword = input.next();

                if(password.equals(repassword)) {
                    a.setPassword(password);
                    System.out.println("密码修改成功");
                    flag = false;
                } else {
                    System.out.println("两次密码不一致");
                    flag = true;
                }
            }while(flag);
        } else {
            System.out.println("原始密码错误");
        }
        showAccountMenu(a);
    }

    /**
     * 取款
     * @param a
     */
    private void getMoney(Account a) {
        System.out.println("请输入取款金额：");
        double money = input.nextDouble();

        if(money <= 0) {
            System.out.println("金额输入错误");
            saveMoney(a);
        } else {
            if(a.getMoney() < money) {
                System.out.println("余额不足");
            } else {
                a.setMoney(a.getMoney() - money);
                System.out.println("取款成功");
            }
            showAccountMenu(a);
        }
    }

    /**
     * 存款
     * @param a
     */
    private void saveMoney(Account a) {
        System.out.println("请输入存款金额：");
        double money = input.nextDouble();

        if(money <= 0) {
            System.out.println("金额输入错误");
            saveMoney(a);
        } else {
            a.setMoney(a.getMoney() + money);
            System.out.println("存款成功");
            showAccountMenu(a);
        }
    }

    /**
     * 显示账户余额
     * @param a
     */
    private void showAccountMoney(Account a) {
        System.out.println("余额：￥" + a.getMoney());
        showAccountMenu(a);
    }

    /**
     * 开户
     */
    private void createAccount() {
        System.out.println("请输入账号：");
        String name = input.next();

        //验证账号是否可用
        Account result = bank.validateByName(name);
        if(result == null) {
            //该账号可用
            boolean flag = false;
            do{
                System.out.println("请输入密码：");
                String password = input.next();

                System.out.println("请确认密码：");
                String repassword = input.next();

                if(password.equals(repassword)) {
                    Account account = new Account();
                    account.setUsername(name);
                    account.setPassword(password);
                    account.setEnable(true);

                    boolean isSave = bank.save(account);

                    if(isSave) {
                        System.out.println("开户成功！");
                    } else {
                        System.out.println("服务器忙，请稍后...");
                    }
                    start();

                } else {
                    System.out.println("两次密码不一致");
                    flag = true;
                }
            }while(flag);

        } else {
            //该账号已被占用
            System.out.println("该账号已被占用");
            createAccount();
        }
    }
}
