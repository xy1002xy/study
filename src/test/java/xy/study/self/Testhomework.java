package xy.study.self;

import com.xy.homework.PlayGame;
import xy.study.self.demo.label.AbstractFigure;

import java.util.Scanner;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-16 20:24
 * @desc:
 **/
public class Testhomework {

//    public static void main(String[] args) {
//        while(true){
//
//            Scanner sc=new Scanner(System.in);
//            int ch=0;
//            ch=sc.nextInt();
//            if (ch==1){
//                System.out.println("==========");
//                Scanner ca=new Scanner(System.in);
//                int max=0;
//                int i=0;
//                int j=0;
//                max=(int)(Math.random()*100);
//                do {
//                    System.out.println("请您输入数字：");
//                    j=ca.nextInt();
//                    if (j<max){
//                        System.out.println("太小了");
//                    }
//                    if (j>max){
//                        System.out.println("太da了");
//                    }
//                    if (j==max){
//                        break;
//                    }
//                    i++;
//                }while (i<10);
//
//            }
//        }
//    }


    public static void main(String[] args) {
        PlayGame pl=new PlayGame();
        pl.menu();

    }


}
