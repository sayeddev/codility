package com.company;

import java.util.*;
import java.util.stream.Stream;

public class BinaryGap {

    public static int solution (int number){
        String binaryNumber = Integer.toBinaryString(number);
        char [] numbers =binaryNumber.toCharArray();
        List<Integer> indexes = new ArrayList<>();
        boolean hasZeros = false;
        for (int i=0 ; i<numbers.length;i++) {
            if (numbers[i] == '1'){
                indexes.add(i);
            }
            else if (numbers[i]== '0'){
                hasZeros =true;
            }
        }
        if (indexes.size()<=1 || hasZeros == false){
            return 0;
        }
        List<Integer> differences = new ArrayList<>();
        for (int i=0;i<indexes.size()-1;i++) {
            differences.add(indexes.get(i+1)-indexes.get(i));
        }
        return Collections.max(differences)-1;
    }
    public static void main(String[] args) {
        System.out.println("Binary gap is : "+ solution(529));
    }
}
