package xy.study.self.demo.nest;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 20:57
 * @desc: 类似于局部变量，不能定义为public，protected，private或者static类型。
         定义方法中，只能方法中声明为final类型的变量。
 **/
public class OuterTolocal {

    public  void execute(){
      final int a = 1;
        /**
         * 创建局部内部类
         */
        class InnerClass1{
            public void execute(){
                System.out.println("LocalInner Class");
                //局部内部类只能访问final类型的变量
                System.out.println(a);
            }
        }
        //只能在所在方法区域创建 在另外的一个类的中不可以创建局部内部类的实例，只能在局部内部类中来创建。
        new InnerClass1().execute();
    }

    public static void main(String[] args) {
        //外部不能直接创建局部内部类
        OuterTolocal localInner = new OuterTolocal();
        localInner.execute();
    }

}
