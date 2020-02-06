package xy.study.self.demo.nest;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 20:46
 * @desc: 内部类
 * 成员内部类可以访问外部类的静态与非静态的方法和成员变量。
 生成成员内部类对象的方法：OuterClass.InnerClass inner = new OuterClass().new InnerClass();
 在内部类中访问外部类的成员变量的方法：OuterClass.this.a;
 **/
public class Outer {

    private  int a = 1;

    public void execute(){
        //在外部类中创建成员内部类
        InnerClass innerClass = new InnerClass();
    }

    /**
     * 成员内部类
     */
    public class InnerClass{
        //内部类可以创建与外部类同名的成员变量
        private int a = 2;
        public void execute(){
            //this引用的是内部类
            System.out.println(a);
            //在内部了中使用外部类的成员变量的方法
            System.out.println(Outer.this.a);
        }
    }

    public static void main(String[] args) {
        //创建成员内部类
        Outer.InnerClass innerClass = new Outer().new InnerClass();
        innerClass.execute();
    }
}