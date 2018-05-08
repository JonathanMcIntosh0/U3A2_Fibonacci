import java.util.ArrayList;
import java.util.List;

/**
 *Database
 */
class FibModel {

    private final List<Long> numberList = new ArrayList<>();

    FibModel() {
        numberList.add(1L);
        numberList.add(1L);
    }

    long getFibonacciNum(int index) throws ArithmeticException {
        if (numberList.size() < index) calcFibonacciNum(index);
        return numberList.get(index - 1);
    }

    private void calcFibonacciNum(int index) throws ArithmeticException {
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
