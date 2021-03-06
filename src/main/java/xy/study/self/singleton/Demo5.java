package xy.study.self.singleton;

import lombok.Getter;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-08 22:15
 * @desc: 单例模式--枚举类型
 **/
@Getter
public enum  Demo5 {

    /**
     * 定义一个枚举元素，这就代表singleton的一个实例
     */
   INSTANCE;

    Demo5() {
    }
}
