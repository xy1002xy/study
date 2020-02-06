package xy.study.self.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-12-10 23:02
 * @desc: 里面用一个List存储product对象的各个部分：
 **/

public class Product {
    private List<String>productList=new ArrayList<>();

    public void addName(String productName){
        productList.add(productName);
    }
    public void show(){
        System.out.println("===========产品创建===============");

        for (String name:productList){
            System.out.println(name);
        }
    }
}
