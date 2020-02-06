package xy.study.self.demo.complex;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-06 07:35
 * @desc:
 *
 */


public class SubClass extends SuperClass {

    @Override
    public void operate1(){
       // 破坏了封装，无意中引入了基类方法
        super.operate1();
        System.out.println("=====我是子类方法operate1======");
    }

    @Override
    public void call(){
        operate1();
    }


    public static void main(String[] args) {
        SubClass subClass=new SubClass();
        System.out.println("==========调用operate1方法==========");
        subClass.operate1();

        System.out.println("==========call==========");
        subClass.call();
    }
}
