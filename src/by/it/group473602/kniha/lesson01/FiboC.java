package by.it.group473602.kniha.lesson01;

import java.util.ArrayList;
import java.util.List;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 12;
        int m = 4;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        List<Long> array = new ArrayList<>();
        int i = 2;
        array.add((long) 0);
        array.add((long) 1);
        while (i < n+1) {
                array.add((array.get(i-1)+array.get(i-2))% m);
            if (array.get(i) == 0 && array.get(i-1) == 1) {
                array.remove(array.size() - 1);
                break;
            }
                i++;
        }
        int rem = (int) (n % array.size());
        return array.get(rem);

    }
}


