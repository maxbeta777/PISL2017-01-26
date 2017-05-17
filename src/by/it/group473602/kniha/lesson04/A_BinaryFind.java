package by.it.group473602.kniha.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
В первой строке источника данных даны:
        - целое число 1<=n<=100000 (размер массива)
        - сам массив A[1...n] из n различных натуральных чисел,
          не превышающих 10E9, в порядке возрастания,
Во второй строке
        - целое число 1<=k<=10000 (сколько чисел нужно найти)
        - k натуральных чисел b1,...,bk не превышающих 10E9 (сами числа)
Для каждого i от 1 до kk необходимо вывести индекс 1<=j<=n,
для которого A[j]=bi, или -1, если такого j нет.

        Sample Input:
        5 1 5 8 12 13
        5 8 1 23 1 11

        Sample Output:
        3 1 -1 1 -1

(!) Обратите внимание на смещение начала индекса массивов JAVA относительно условий задачи
*/

public class A_BinaryFind {
    int[] findIndex(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер отсортированного массива
        int arraySize = scanner.nextInt();
        //сам отсортированный массива
        int[] array =new int[arraySize];
        for (int i = 1; i <= arraySize; i++) {
            array[i-1] = scanner.nextInt();
        }

        //размер массива индексов
        int resultArraySize = scanner.nextInt();
        int[] resultArray = new int[resultArraySize];
        for (int i = 0; i < resultArraySize; i++) {
            int value = scanner.nextInt();
            //тут реализуйте бинарный поиск индекса
            int leftPart = 0;
            int rightPart = arraySize;
            int center;
            while (leftPart < rightPart) {
                center = (leftPart + rightPart) / 2;
                if (array[center] == value) {
                    resultArray[i] = ++center;
                    break;
                } else {
                    if (array[center] > value) {
                        rightPart = --center;
                    } else {
                        leftPart = ++center;
                    }
                }
                resultArray[i] = -1;
            }
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return resultArray;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473602/kniha/lesson04/dataA.txt");
        A_BinaryFind instance = new A_BinaryFind();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.findIndex(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }
}
