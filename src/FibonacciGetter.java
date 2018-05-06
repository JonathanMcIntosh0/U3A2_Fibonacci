import java.util.Arrays;
import java.util.List;

class FibonacciGetter {
    private static List<Long> numberList = Arrays.asList(1L, 1L);

    static long getFibonacciNum(int index) {
        if (numberList.size() < index) calcFibonacciNum(index);
        return numberList.get(index - 1);
    }

    private static void calcFibonacciNum(int index) {
        for (int i = numberList.size() - 1; i < index; i++) {
            long nextNumber = numberList.get(i) + numberList.get(i - 1);
            if (nextNumber < 0) {
                throw new ArithmeticException();
            } else {
                numberList.add(nextNumber);
            }
        }
    }

}
