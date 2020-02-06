package xy.study.self.demo.label;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-08 22:49
 * @desc: 标签类 (过于冗长，容易出错并且效率低下)
 **/
 class Figure {

    enum Shape{RECTANGLE,CIRCLE};

    //标签域
    final Shape shape;

    double length;
    double width;

    double radius;

    public Figure(double radius) {
        shape=Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(double length, double width) {
        shape =Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area(){
        switch (shape){
            case CIRCLE:
                return Math.PI *(radius * radius);
            case RECTANGLE:
                return length * width ;
            default:
                throw new AssertionError(shape);
        }
    }
}
