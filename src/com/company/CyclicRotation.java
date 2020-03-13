package com.company;

import java.util.Arrays;

public class CyclicRotation {

    public static int[] solution(int[]a, int noOfShifts) {
        for (int j=0;j<noOfShifts;j++) {
            int temp = a[0];
            int temp1 = 0;
            for (int i = 0; i < a.length; i++) {
                if (i == a.length - 1) {
                    a[0] = temp;
                } else {
                    temp1 = a[i + 1];
                    a[i + 1] = temp;
                    temp = temp1;
                }
            }
            System.out.println("Round"+(j+1) +": ");
            Arrays.stream(a).forEach(System.out::println);
        }
        return a;
    }

    public static void main(String[] args) {
        int a[] = {3, 8, 9, 7, 6};
        solution(a,2);
    }
}
