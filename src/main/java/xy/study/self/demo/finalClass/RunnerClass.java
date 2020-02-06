package xy.study.self.demo.finalClass;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-05 21:40
 * @desc:
 **/
public class RunnerClass implements Runnable {

    @Override
    public void run() {
        for (int i =1;i<10; i++){
            FinaClass finaClass =new FinaClass(12,13);
            System.out.println("RunnerClass==="+i+"======>"+finaClass.plus(finaClass));
            System.out.println("类的实例====》"+finaClass.plus(finaClass).toString());
        }
        System.out.println(new FinaClass(12,13));
    }
}
