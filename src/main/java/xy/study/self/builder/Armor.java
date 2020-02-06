package xy.study.self.builder;

import lombok.Getter;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 13:33
 * @desc:
 **/
@Getter
public enum Armor {

    CLOTHES("clothes"), LEATHER("leather"), CHAIN_MAIL("chain mail"), PLATE_MAIL("plate mail");

    private String name;

    Armor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
