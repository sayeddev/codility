package com.company;

import java.time.LocalTime;
import java.util.Set;
import java.util.TreeMap;

public class Main {


    public static int solution(String S) {
        // write your code in Java SE 8
        int output=0;
        String[] elements = S.split(Character.toString((char)10));
        TreeMap<Integer,Integer> result = new TreeMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (String e : elements) {
            String[] element = e.split(",");
            String time =element[0];
            Integer number = Integer.parseInt(element[1].replaceAll("-",""));
            LocalTime t = LocalTime.parse(time);
            int sum = t.getMinute()+ (t.getSecond() > 0 ? +1:0);
            int total = 0;
            if (sum >=5 ) {
                total = sum * 150;
            } else {
                total = (t.getMinute() * 60 + (t.getSecond() > 0 ? +1:0)) * 3;
            }
            if (treeMap.containsKey(number)){
                treeMap.put(number,total + treeMap.get(number));
            } else {
                treeMap.put(number,total);
            }

        }
        Set<Integer> keys = treeMap.keySet();
        for(Integer key: keys){
            result.put(treeMap.get(key),key);
        }
        if(result.size() == 1) {
            output = result.firstEntry().getValue();

        } else{
            Set<Integer> keysMap = result.keySet();
            for(Integer key: keysMap){
                output+= key;
            }
            output-= result.lastEntry().getKey();
        }
        System.out.println("Output is : " + output);
        return  output;
    }


/*    public static String solution(String S, String C) {
        StringBuilder finalResult= new StringBuilder();
        String[] names = S.split("; ");
        HashMap<String,String[]> parsedNames= new HashMap<>();
        HashMap<String,String> nameEmails = new HashMap<>();
        char[] chArr = C.toCharArray();
        chArr[0] = Character.toLowerCase(chArr[0]);
        final String company = new String(chArr);
       for (int i=0; i<names.length; i++) {
           String  temp = names[i];
           String[] values = temp.split(" ");
           if(values.length ==3) {
               values[2] = parseLastName(values[2]);
               values[1] = values[2];
               values[2]=null;
           } else {
               values[1] = parseLastName(values[1]);
           }
           parsedNames.put(temp,values);
       }

        parsedNames.forEach((k,v)->{
            String email ="";
            String[] namesInMap = v;
            email = namesInMap[0]+ "." + namesInMap[1] + "@" + company +".com";
            if (nameEmails.containsKey(email)){
                char lastChar = namesInMap[1].charAt(namesInMap[1].length()-1);
                if (Character.isDigit(lastChar)) {
                     int last = Integer.parseInt(String.valueOf(lastChar))+1;
                    namesInMap[1] = namesInMap[1].substring(0, namesInMap[1].length()) + String.valueOf(last);
                } else {
                    namesInMap[1] = namesInMap[1].substring(0, namesInMap[1].length()) + 2;
                }
                email = namesInMap[0]+ "." + namesInMap[1] + "@" + company +".com";
            }
            nameEmails.put(email,k);
        });

        nameEmails.forEach((k,v)->{
            finalResult.append(v).append(" <").append(k).append(">; ");
        });
        System.out.println(finalResult.toString());
        return  finalResult.toString();
    }


    public static String parseLastName (String lastName) {
        String result="";
        result = lastName.replaceAll(";","");
        if(result.length() > 8) {
            result =result.substring(0,7);
        }
        char[] chArr = result.toCharArray();
        chArr[0] = Character.toLowerCase(chArr[0]);
        return new String(chArr);
    }*/
    public static void main(String[] args) {
        //String s = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
       // solution(s, "yahoo");
        solution("00:01:07,400-234-090\n" +
                "00:05:01,701-080-080\n" +
                "00:05:00,400-234-090");
    }
}
