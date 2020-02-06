package xy.study.self.demo.label;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 22:11
 * @desc: 圆形
 **/
public class Circle extends AbstractFigure{

    final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double area() {
        return Math.PI *(radius * radius);
    }
}
