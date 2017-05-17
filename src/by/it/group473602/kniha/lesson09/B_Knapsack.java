package by.it.group473602.kniha.lesson09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: рюкзак без повторов

Первая строка входа содержит целые числа
    1<=W<=100000     вместимость рюкзака
    1<=n<=300        число золотых слитков
                    (каждый можно использовать только один раз).
Следующая строка содержит n целых чисел, задающих веса каждого из слитков:
  0<=w[1]<=100000 ,..., 0<=w[n]<=100000

Найдите методами динамического программирования
максимальный вес золота, который можно унести в рюкзаке.

Sample Input:
10 3
1 4 8
Sample Output:
9

*/

public class B_Knapsack {

    int getMaxWeight(InputStream stream ) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        Scanner scanner = new Scanner(stream);
        int weight = scanner.nextInt();
        int count = scanner.nextInt();
        int value[] = new int[count];
        for (int i = 0; i < count; i++) {
            value[i] = scanner.nextInt();
        }

        int[][] maxWeight = new int[weight + 1][count + 1];
        for (int i = 0; i < weight + 1; i++) {
            maxWeight[i][0] = 0;
        }
        for (int i = 0; i < count + 1; i++) {
            maxWeight[0][i] = 0;
        }

        for (int i = 1; i < count + 1; i++) {
            for (int w = 1; w < weight + 1; w++) {
                maxWeight[w][i] = maxWeight[w][i - 1];
                if (value[i - 1] <= w) {
                    int newWeight = maxWeight[w - value[i - 1]][i - 1] + value[i - 1];
                    if (maxWeight[w][i] < newWeight) {
                        maxWeight[w][i] = newWeight;
                    }
                }
            }
        }
        for (int i = 1; i < count + 1; i++) {
            for (int w = 1; w < weight + 1; w++) {
                System.out.print(maxWeight[w][i]);
            }
            System.out.println();
        }
        int result = maxWeight[weight][count];
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473602/kniha/lesson09/dataB.txt");
        B_Knapsack instance = new B_Knapsack();
        int res=instance.getMaxWeight(stream);
        System.out.println(res);
    }

}

