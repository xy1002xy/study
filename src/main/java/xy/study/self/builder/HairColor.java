package xy.study.self.builder;

import lombok.Getter;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 13:40
 * @desc:
 **/
@Getter
public enum HairColor {
    WHITE, BLOND, RED, BROWN, BLACK;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
