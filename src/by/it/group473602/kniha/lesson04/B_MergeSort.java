package by.it.group473602.kniha.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

    int[] merge(int[] array1, int[] array2){
        int arraySize = array1.length + array2.length;
        int[] result = new int[arraySize ];
        int leftArrayIndex = 0;
        int rightArrayIndex  = 0;
        for (int i = 0; i < arraySize ; i++){
            if (leftArrayIndex >= array1.length && rightArrayIndex < array2.length){
                result[i] = array2[rightArrayIndex];
                rightArrayIndex++;
            }else if(rightArrayIndex >= array2.length && leftArrayIndex < array1.length){
                result[i] = array1[leftArrayIndex];
                leftArrayIndex++;
            }else if (array1[leftArrayIndex] <= array2[rightArrayIndex] && leftArrayIndex < array1.length){
                result[i] = array1[leftArrayIndex];
                leftArrayIndex++;
            }else {
                result[i] = array2[rightArrayIndex];

                rightArrayIndex++;
            }
        }
        return result;
    }

    int[] mergeSort(int[] arr, int l, int r){
        int[] result = new int[1];
        int index = (int)(l + r) / 2;
        if (l < r){
           return merge(mergeSort(arr, l, index), mergeSort(arr, index + 1, r));
        }else {
            result[0] = arr[l];
            return result;
        }
    }

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер массива
        int j=0;
        int arraySize = scanner.nextInt();
        //сам массива
        int[] array=new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
            System.out.println(array[i]);
            j++;
        }
        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием

        array = mergeSort(array, 0, array.length - 1);




        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return array;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473602/kniha/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
