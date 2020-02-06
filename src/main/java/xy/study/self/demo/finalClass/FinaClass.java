package xy.study.self.demo.finalClass;

/**
 * @program: sell
 * @author: wxy
 * @create: 2019-05-05 20:18
 * @desc:
 **/
public  class FinaClass {

    private   double re ;
    private   double im ;

    public FinaClass(double re,double im) {
        this.re=re;
        this.im=im;
    }

    public double realPart(){
        return re;
    }
    public double imaginaryPart(){
        return im;
    }

    public FinaClass plus(FinaClass finaClass){
        return new FinaClass(re + finaClass.re,im+finaClass.im);
    }
    public FinaClass minus(FinaClass finaClass){
        return new FinaClass(re - finaClass.re,im-finaClass.im);
    }

    public FinaClass times(FinaClass finaClass){
        return new FinaClass(re * finaClass.re - im*finaClass.im,re * finaClass.re+im*finaClass.im);
    }

    public FinaClass dividedBy(FinaClass finaClass){
        double temp =finaClass.re * finaClass.re+finaClass.im*finaClass.im;
        return new FinaClass((re * finaClass.re + im*finaClass.im)/temp,(im * finaClass.re-re*finaClass.im)/temp);
    }

    @Override
    public  boolean equals(Object o){
        if (o==this){
            return true;
        }
        if (!(o instanceof FinaClass)){
            return false;
        }
        FinaClass finaClass=(FinaClass)o;
        return  Double.compare(finaClass.re,re)==0 &&
                Double.compare(finaClass.im,im)==0;
    }

//    @Override
//    public  int hashCode(){
//        return 31*Double.hashCode(re)+Double.hashCode(im);
//    }

//    @Override
//    public String toString(){
//        return "("+re + "+" + im +"i)";
//    }
}
