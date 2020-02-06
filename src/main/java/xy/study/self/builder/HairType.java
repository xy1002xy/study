package xy.study.self.builder;

import lombok.Getter;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-11 13:32
 * @desc:
 **/
@Getter
public enum HairType {
    BALD("bald"), SHORT("short"), CURLY("curly"), LONG_STRAIGHT("long straight"), LONG_CURLY(
            "long curly");

    private String title;

    HairType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
