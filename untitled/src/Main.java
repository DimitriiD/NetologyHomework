public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        Integer c = calc.devide.apply(a, b);
        calc.println.accept(c);

        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener errorListener = System.out::println;
        Worker worker = new Worker(listener,errorListener);
        worker.start();
    }
}
