package xy.study.self.atm.domain;

import lombok.Data;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-05-10 21:23
 * @desc:
 **/
@Data
public class Account {
    private String username;
    private String password;
    private double money;
    private boolean enable;
}
