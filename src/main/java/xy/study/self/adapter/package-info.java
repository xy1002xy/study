/**
* @program: sell
*
* @author: wxy
*
* @create: 2018-12-12 20:41
*
* @desc: 适配器模式
类适配器：想调用B接口中的方法（A中没有），可以通过一个class 实现B接口，然后通过适配器去继承class然后实现A接口
对象适配器：把接口作为目标接口中构造器的参数，定义一个方法，里面引入该对象下的方法
接口适配器：如果A中有很多接口，但是并不需要都实现，则定一个抽象适配器类去实现A，然后定义类去继承适配器类，重写所需要的方法即可
**/package xy.study.self.adapter;