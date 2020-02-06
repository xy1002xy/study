package xy.study.self.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-10 21:22
 * @desc:
 **/
public class DynamicClass implements InvocationHandler {

    Study study;

    /**
     * 需要处理真实的角色关系，所以要把真实的对象穿进来
     * @param study
     */
    public DynamicClass(Study study ) {
        this.study=study;
    }

    /**
     *
     * @param proxy 代理类
     * @param method 调用的方法
     * @param args 调用的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===========开始调用代理类========");
        if (method.getName().equals("read")){
            method.invoke(study,args);
            System.out.println("调用的是读书的方法");
        }
        if (method.getName().equals("write")){
            method.invoke(study,args);
            System.out.println("调用的是写作业的方法");
        }
        return null;
    }
}
