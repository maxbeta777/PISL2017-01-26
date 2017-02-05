package by.it.group473602.kniha.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();
    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом

        FiboB fibo = new FiboB();
        //   int n = 55555;
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        List<BigInteger> array = new ArrayList<>();
        array.add(BigInteger.ONE);
        array.add(BigInteger.ONE);
        if (n==1 || n==2)
            return BigInteger.ONE;
        for (int i = 2; i < n + 1; i++) {
            array.add(array.get(i - 2).add(array.get(i - 1)));
        }
        return array.get(n-1);
    }




}