import java.math.BigInteger;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class HomeWork_1 {
    public static void main(String[] args) {
        /*
        System.out.println("Задача 1. Сумма");
        ex_1_1();
        System.out.println();
        
        System.out.println("Задача 1. Факториал");
        ex_1_2();
        System.out.println();
        
        System.out.println("Задача 2. Простые числа от 1 до 1000");
        ex_2();
        System.out.println();
        

        System.out.println("Задача 3. Простой калькулятор");
        ex_3();
        System.out.println();
        */

        System.out.println("Задача 4. Выражение");
        ex_4();
    }

    //  функция подсчёта суммы n натуральных чисел циклом
    static int ex1_1_iter(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    //  функция подсчёта суммы n натуральных в одно арифметическое выражение
    static int ex1_1_quick(int n){
        // сумма арифметической прогрессии от 1 до n с шагом 1
        return (1 + n) * n / 2;
    }

    //  функция вывода в консоль результата решения зазачи 1 (сумма)
    static void ex_1_1(){
        System.out.print("  Введите натуральное число ");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        sc.close();
        System.out.println("  Результат вычислений циклом: " + ex1_1_iter(value));
        System.out.println("  Результат вычислений формулой: " + ex1_1_quick(value));
        
    }

    //  функция вычисления n!
    //  взяла тип длинных целых чисел, т.к. факториал очень уж быстро растёт с ростом n
    static BigInteger factorial(int n){
        BigInteger f = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    //  функция вывода в консоль результата решения зазачи 1 (факториал)
    static void ex_1_2(){
        System.out.print("  Введите натуральное число ");
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        scan.close();
        System.out.println("  " + value + "! = " + factorial(value));        
    }

    //  функция проверки числа на простоту
    static boolean isPrime(int n){
        if (n == 1)
            return false;
        if (n == 2)
            return true;    
        for (int del = 2; del*del <= n; del++)
            if (n % del == 0)
                return false;
        return true; 
    }

    //  функция вывода в консоль результата решения зазачи 2
    static void ex_2(){
        for (int i = 1; i <= 1000; i++) 
            if(isPrime(i))
                System.out.print(i + "  ");
        System.out.println();                
    }

    // функция для построения выражения калькулятора
    static String calc(){
        String res = "";
        System.out.print("  Введите первый операнд ");
        Scanner scan = new Scanner(System.in);
        int value1 = scan.nextInt();

        System.out.print("  Введите знак арифметической операции ");
        char operation = scan.next().charAt(0);
        System.out.print("  Введите второй операнд ");
        int value2 = scan.nextInt();
        scan.close();

        switch (operation){
            case '+': res = Integer.toString(value1) + " + " + Integer.toString(value2) + " = " + Integer.toString(value1+value2); break;
            case '-': res = Integer.toString(value1) + " - " + Integer.toString(value2) + " = " + Integer.toString(value1-value2); break;
            case '*': res = Integer.toString(value1) + " + " + Integer.toString(value2) + " = " + Integer.toString(value1*value2); break;
            case '/': if (value2 == 0) res = "Ошибка! На 0 делить нельзя!";
                      else res = Integer.toString(value1) + " / " + Integer.toString(value2) + " = " + Double.toString((double)(value1) / value2); break;
            default: res = "Ошибка! Неверная арифметическая операция!" ;         
        }
        return res;
    }

    //  функция вывода в консоль результата решения зазачи 2
    static void ex_3(){
        System.out.println("  " + calc());
    }


    //  дополнительная задача
    /*
     * Задано уравнение вида q + w = e, q, w, e >= 0.
     * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
     * Требуется восстановить выражение до верного равенства.
     * Предложить хотя бы одно решение или сообщить, что его нет
    */

    // я работаю в предположении, что в каждом слагаемом не более одного вопроса
    static void ex_4(){
        try(Scanner sc = new Scanner(System.in)){
            //String expression = sc.nextLine();
            String expression = "29? + 114 = 404";
            System.out.println(expression);
            expression = expression.replaceAll(" ", "");
            String[] part = expression.split("=");
            int right_part = Integer.parseInt(part[1]);
            
            String sl1 = part[0].substring(0, part[0].indexOf("+"));
            String sl2 = part[0].substring(part[0].indexOf("+")+1);
            
            int res1 = 0;
            int pos_digitX = -1;
            if (sl1.indexOf("?") == -1)
                res1 = Integer.parseInt(sl1);
            else
            {
                int n = sl1.length();
                int st10 = 1;                
                for (int i = n-1; i >=0; i--) {
                    char c = sl1.charAt(i);
                    if (Character.isDigit(c)){
                        res1 += (c - '0') * st10;
                    }
                    else
                        pos_digitX = st10;
                    st10 *= 10;
                }
            }
            
            int res2 = 0;
            int pos_digitY = -1;
            if (sl2.indexOf("?") == -1)
                res2 = Integer.parseInt(sl2);
            else
            {
                int n = sl2.length();
                int st10 = 1;                
                for (int i = n-1; i >=0; i--) {
                    char c = sl2.charAt(i);
                    if (Character.isDigit(c)){
                        res2 += (c - '0') * st10;
                    }
                    else
                        pos_digitY = st10;
                    st10 *= 10;
                }
            }

            if (pos_digitX == -1 && pos_digitY == -1)
                if(res1 + res2 == right_part)
                   System.out.println(res1 + " + "  + res2 + " = " + right_part);
                else
                    System.out.println("Неверное выражение!");
            else
               if (pos_digitX == -1)
                {
                    boolean candoit = false;
                    for (int i = 0; i < 10; i++) {
                        if (res1  +  res2 + i*pos_digitY  == right_part)
                            {
                                System.out.println(res1 + " + " + (res2 + i*pos_digitY) + " = " + right_part);
                                candoit = true;
                                break;
                            }                        
                    }
                    if (! candoit) System.out.println("Невозможное выражение");         
                }
                else if (pos_digitY == -1)
                    {
                        boolean candoit = false;
                        for (int i = 0; i < 10; i++) {
                            if (res1 + i*pos_digitX  +  res2  == right_part)
                                {
                                    System.out.println((res1 + i*pos_digitX) + " + " + res2  + " = " + right_part);
                                    candoit = true;
                                    break;
                                }                        
                        }
                        if (! candoit) System.out.println("Невозможное выражение");         
                    } 
                    else {
                        boolean candoit = false;
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) 
                            if (res1 + i*pos_digitX  +  res2 + j*pos_digitY == right_part)
                                {
                                    System.out.println((res1 + i*pos_digitX) + " + " + (res2 + j*pos_digitY)  + " = " + right_part);
                                    candoit = true;
                                    break;
                                }
                            if(candoit)break;                            
                        }
                        if (! candoit) System.out.println("Невозможное выражение");  
                    } 
        }
    }







}
