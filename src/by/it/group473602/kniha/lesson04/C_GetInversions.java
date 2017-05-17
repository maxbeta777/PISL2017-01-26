package by.it.group473602.kniha.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Рассчитать число инверсий одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо посчитать число пар индексов 1<=i<j<n, для которых A[i]>A[j]A[i]>A[j].

    (Такая пара элементов называется инверсией массива.
    Количество инверсий в массиве является в некотором смысле
    его мерой неупорядоченности: например, в упорядоченном по неубыванию
    массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
    инверсию образуют каждые (т.е. любые) два элемента.
    )

Sample Input:
5
2 3 9 2 9
Sample Output:
2

Головоломка (т.е. не обязательно).
Попробуйте обеспечить скорость лучше, чем O(n log n) за счет многопоточности.
Докажите рост производительности замерами времени.
Большой тестовый массив можно прочитать свой или сгенерировать его программно.
*/


public class C_GetInversions {

    int calc(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int arraySize = scanner.nextInt();
        //сам массив
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int result = 0;
        //!!!!!!!!!!!!!!!!!!!!!!!!     тут ваше решение   !!!!!!!!!!!!!!!!!!!!!!!!
        result = (int) calculateInversions(array);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private long calculateInversions(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        int center = (array.length + 1) / 2;
        int leftArray[] = Arrays.copyOfRange(array, 0, center);
        int rightArray[] = Arrays.copyOfRange(array, center, array.length);
        return calculateInversions(leftArray) + calculateInversions(rightArray) + merge(array, leftArray, rightArray);
    }

    private long merge(int[] result, int[] array1, int[] array2){
        int leftArrayIndex = 0, rightArrayIndex  = 0, count = 0;
        for (int i = 0; i < result.length ; i++){
            if (leftArrayIndex >= array1.length && rightArrayIndex < array2.length){
                result[i] = array2[rightArrayIndex];
                rightArrayIndex++;
                 result[i] = array1[leftArrayIndex];
                leftArrayIndex++;
            }else if (array1[leftArrayIndex] <= array2[rightArrayIndex] && leftArrayIndex < array1.length){
                result[i] = array1[leftArrayIndex];
                leftArrayIndex++;
            }else {
                result[i] = array2[rightArrayIndex];
                count = array1.length - leftArrayIndex;
                rightArrayIndex++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473602/kniha/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
