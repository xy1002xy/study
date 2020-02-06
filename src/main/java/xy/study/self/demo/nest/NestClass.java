package xy.study.self.demo.nest;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-07 08:20
 * @desc: 内部类
 **/
public class NestClass {

    int cnt = 0;

    public class Cnt {
        int cnt = 10;
        public void increment() {
            cnt++;
            NestClass.this.cnt++;
        }
        public void dispValues() {
            System.out.println("Inner: " + cnt);
            System.out.println("Outer: " + NestClass.this.cnt);
        }
    }

    public void go() {
        Cnt counter = new Cnt();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.dispValues();
    }

    public static void main(String args[]) {
        NestClass otv = new NestClass();
        otv.go();
    }

}
