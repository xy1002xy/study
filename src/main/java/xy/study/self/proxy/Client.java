package xy.study.self.proxy;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-10 21:34
 * @desc: 测试动态代理
 **/
public class Client {

    public static void main(String[] args) {

        //真实对象
       // Study realClass=new OldBrother();
          Study realClass=new SomeOne();
        DynamicClass dynamicClass =new DynamicClass(realClass);

        //代理对象
        Study proxyClass= (Study) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Study.class},
                dynamicClass);

        proxyClass.read();
        proxyClass.write();

        //获取前一天时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        System.out.println(sdf.format(date));


}

}
