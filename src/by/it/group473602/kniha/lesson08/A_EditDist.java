package by.it.group473602.kniha.lesson08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Рекурсивно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class A_EditDist {
    int editDist(int i, int j, int[][] D, String one, String two) {
        if (D[i][j] == Integer.MAX_VALUE) {
            if (i == 0) {
                D[i][j] = j;
            } else if (j == 0) {
                D[i][j] = i;
            } else {
                int ins = editDist(i, j - 1, D, one, two) + 1; //в правую клетку считаем вставки
                int del = editDist(i - 1, j, D, one, two) + 1; //в нижнюю клетку считаем удаления
                int cost = (one.charAt(i - 1) != two.charAt(j - 1) ? 1 : 0); //проверка несоответствия элемента 1-i и 2-j
                int sub = editDist(i - 1, j - 1, D, one, two) + cost;//по диагонали замена
                int min = Integer.min(ins, del);//поиск минимального значения среди ins del sub
                min = Integer.min(min, sub); // -//-
                D[i][j] = min;
            }
        }

        return D[i][j];
    }

    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        int n = one.length();
        int m = two.length();
        int[][] D = new int[n+1][m+1];//массив редакционных предписаний
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                D[i][j] = Integer.MAX_VALUE; //инициализация всех значений бесконечностью
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                editDist(i, j, D, one, two); //построчно заполняем матрицу
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print("\t" + D[i][j]); //вывод матрицы
            }
            System.out.println();
        }

        int result = D[n][m]; //вывод правого нижнего угла матрицы
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473602/kniha/lesson08/dataABC.txt");
        A_EditDist instance = new A_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
    }
}