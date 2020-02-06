package xy.study.self.builder;

import lombok.Getter;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 13:29
 * @desc:
 **/
@Getter
public enum Profession {

    WARRIOR, THIEF, MAGE, PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
