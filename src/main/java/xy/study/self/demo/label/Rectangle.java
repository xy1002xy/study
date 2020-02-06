package xy.study.self.demo.label;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 22:12
 * @desc: 矩形
 **/
public class Rectangle extends AbstractFigure {

    final double length;
    final  double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width ;
    }
}
