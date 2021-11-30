public class Complex {
    private Integer realPart;
    private Integer imaginaryPart;

    public Integer getRealPart() {
        return realPart;
    }

    public Integer getImaginaryPart() {
        return imaginaryPart;
    }

    public void setRealPart(Integer realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(Integer imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public Complex(Integer realPart, Integer imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return realPart + "+" +
                 imaginaryPart +
                'i';
    }

    public Complex add(Complex anotherComplex){
        Complex result_complex = new Complex(0,0);
        result_complex.setRealPart(this.realPart + anotherComplex.getRealPart());
        result_complex.setImaginaryPart(this.imaginaryPart + anotherComplex.getImaginaryPart());
        return result_complex;
    }

    public Complex addAnther(int anotherReal,int anotherImaginary){
        Complex result_complex = new Complex(0,0);
        result_complex.setRealPart(this.realPart + anotherReal);
        result_complex.setImaginaryPart(this.imaginaryPart + anotherImaginary);
        return result_complex;
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(3,4);
        System.out.println(c1.add(c2));

    }
}
