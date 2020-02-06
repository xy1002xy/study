/**
* @program: sell
*
* @author: wxy
*
* @create: 2019-05-05 23:24
*
* @desc: 复合优先于继承
       与方法调用不同的是，继承打破了封装性
       复合(composition):不扩展现有的类，而是在新的类中增加一个私有域，引用现有类的一个实例
       转发(fowarding):新类中的每个实例方法都可以调用被包含的现有类实例中对应的方法，并返回结果。
       只有当子类真正是超类的子类型时，才适合用继承。
        is -a 用继承 编译期决定
        has -a 用组合 运行时决定

      1.考虑使用多态，可以用继承。
      2.考虑复用父类方法，而且父类很少改动，可以用继承。
      其他情况请慎重使用继承。
    子类继承必须包含所有父类方法，增加了出错率，修改父类方法会引起所有子类功能变化。

    Java -- 子类使用super调用父类的方法A，A 调用了方法B，
    子类也override方法B，那么super.A()最终调用到了子类的B方法
**/package xy.study.self.demo.complex;