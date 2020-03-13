package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OddOccurrencesInArray {


    public static int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 0;
        }
        Map<Integer,Integer> output = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (output.containsKey(A[i])){
                output.put(A[i],(output.get(A[i])+1));
            }else {
                output.put(A[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> element: output.entrySet()) {
            if(element.getValue()<2){
                System.out.println(element.getKey());
                return element.getKey().intValue();
            }
        }
        return 0;
    }
    public static int solution2(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 0;
        }
        Map<Integer,Integer> output = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (output.containsKey(A[i])){
                output.put(A[i],output.get(A[i])+1);
            }else {
                output.put(A[i],1);
            }
        }
        Optional<Map.Entry<Integer, Integer>> map = output.entrySet().stream().filter(entry -> entry.getValue()<2).findFirst();
        return map.isPresent()? map.get().getKey() : 0;
    }
    public static void main(String[] args) {
        solution(new int[]{1,2,1,2,1,2,24,3,3});
    }
}
