package test;

import java.util.Scanner;

public class Test01 {
    public static int getArea(int width, int height){
        return width * height;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in).useRadix(10);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        System.out.println(getArea(width, height));
    }
}
