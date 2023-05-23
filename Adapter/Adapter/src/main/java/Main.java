public class Main {
    public static void main(String[] args) {
        Ints calc = new IntsCalculator();
        System.out.println(calc.sum(100,11));
        System.out.println(calc.mult(100,11));
        System.out.println(calc.pow(2,11));
    }
}