package by.it.group473602.kniha.lesson09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Даны число 1<=n<=100 ступенек лестницы и
целые числа −10000<=a[1],…,a[n]<=10000, которыми помечены ступеньки.
Найдите максимальную сумму, которую можно получить, идя по лестнице
снизу вверх (от нулевой до n-й ступеньки), каждый раз поднимаясь на
одну или на две ступеньки.

Sample Input 1:
2
1 2
Sample Output 1:
3

Sample Input 2:
2
2 -1
Sample Output 2:
1

Sample Input 3:
3
-1 2 1
Sample Output 3:
3

*/

public class C_Stairs {

    int getMaxSum(InputStream stream ) {
        Scanner scanner = new Scanner(stream);
        int count=scanner.nextInt();
        int stairs[]=new int[count];
        for (int i = 0; i < count; i++) {
            stairs[i]=scanner.nextInt();
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        final int step = 2;
        int[] maxSum = new int[count + 1];
        for (int i = 0; i < count; i++) {
            maxSum[i] = 0;
        }
        int newBestStep = 0;
        int k = 0;
        for (int i  = 0; i < count-1; i++) {
            for (int j = 1; j < count; j++) {
                if (stairs[i] < stairs[j]) {
                    newBestStep = stairs[j] + maxSum[k];
                    maxSum[++k] = newBestStep;
                } else if (stairs[i] < stairs[j]) {
                    newBestStep = stairs[i] + maxSum[k];
                    maxSum[++k] = newBestStep;
                }
            }
        }
        for (int i = 0; i < count; i++) {
                System.out.print(maxSum[i]);
        }
        System.out.println();
        int result = maxSum[count-1];
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473602/kniha/lesson09/dataC.txt");
        C_Stairs instance = new C_Stairs();
        int res=instance.getMaxSum(stream);
        System.out.println(res);
    }

}

