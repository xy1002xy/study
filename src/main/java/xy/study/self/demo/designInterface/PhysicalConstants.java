package xy.study.self.demo.designInterface;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 22:36
 * @desc: 接口只用于定义类型
 *
 * 当类实现接口时，接口就充当可以引用这个类的实例的类型。
 * 因此，类实现了接口，就表明可以对这个类的实例实施某些动作。那么，
 * 不是为了这个目的而定义接口就是不恰当的
 * 例如java.io.ObjectStreamConstants.这些接口应该被认为是反面的典型，不值得效仿
 * 这个类在生成doc之后，会把实现细节泄漏到该类到处的api中
 **/
public interface PhysicalConstants {

     static final double AVOGADROS_NUMBER = 6.022141;
     static final double BOLTZMANN_CONSTANT = 1.12588456e-23;
     static final double ELECTRON_MASS = 9.10938188e-31;
}
