import java.util.Scanner;

public class Sort {

    static int len,order;
    static int[] array;

    public static void main(String[] args)
    {
        //while(true)
        //{//test for the whole program.
            input();
            show_array(array,order);
        //}
    }

    public static void input()
    {
        Scanner sc = new Scanner(System.in);//input
        System.out.println("Program:input the length of number array.");
        System.out.print("User:");
        len = sc.nextInt();
        array = new int[len];

        System.out.println("Program:input the number array.");
        System.out.print("User:");
        for(int i = 0; i < len; i++)
        {
            array[i] = sc.nextInt();
        }
        /*for(int i:array) {
            System.out.print(i + " ");//test print out for array.
        }*/

        System.out.println("Program:chose a way to sort the number array.");
        Loop1: while (true)
        {
            System.out.println("Program:input 1 to use bubble sort.");
            System.out.println("Program:input 2 to use select sort.");
            //System.out.println("Program:input 3 to use  sort.");
            System.out.print("User:");
            int method = sc.nextInt();
            switch (method)
            {
                case 1:
                    bubble_sort(array);
                    break Loop1;
                case 2:
                    select_sort(array);
                    break Loop1;
                default:
                    System.out.println("Program:input error!");
                    break;
            }
        }

        System.out.println("Program:set the order.");
        while (true)
        {
            System.out.println("Program:input 1 from small to big.");
            System.out.println("Program:input 2 from big to small.");
            System.out.print("User:");
            order = sc.nextInt();
            if (order != 1 && order != 2)
            {
                System.out.println("Program:input error!");
            }
            else
            {
                break;
            }
        }
    }

    public static void bubble_sort(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            for (int tmp = 0; tmp < array.length - i; tmp++)
            {
                if (array[tmp] > array[tmp + 1]) {//set '<' or '>' to change different order.
                    array[tmp + 1] = array[tmp + 1] + array[tmp];
                    array[tmp] = array[tmp + 1] - array[tmp];
                    array[tmp + 1] = array[tmp + 1] - array[tmp];
                }
            }
        }
    }

    public static void select_sort(int[] array)
    {
        int max,max_tmp = 0;
        for (int i = 1; i < array.length; i++)
        {
            for (int j = 0; j <= array.length - i; j++)
            {
                if (array[j] > array[max_tmp])
                {
                    max_tmp = j;
                }
            }
            max = array[max_tmp];
            array[max_tmp] = array[array.length - i];
            array[array.length - i] = max;
            max_tmp = 0;
        }
    }

    public static void reverse_sort(int[] array)
    {
        for (int i = 0; i < array.length / 2; i++)
        {
            if (array[i] < array[array.length - 1 - i])
            {
                array[i] = array[i] + array[array.length - 1 - i];
                array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
                array[i] = array[i] - array[array.length - 1 - i];
            }
        }
    }

    public static void show_array(int[] array, int order)
    {
        System.out.print("Program:");
        if (order == 2)
        {
            reverse_sort(array);
        }
        for (int tmp:array) System.out.print(tmp + " ");
        System.out.println();
    }
}