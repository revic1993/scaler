package dsa.scaler.hashmap;

import java.util.HashMap;

public class WindowString {

    public static void main(String[] args) {
        WindowString ws = new WindowString();
        System.out.println(ws.minWindow("TquFYBhPdnv7B40ibLTOIaKFVPpzaTx6z5svvfHI02Ul050z0fMC2gmuHDoV8mfVSecxZKink1fdgcFO7IqzSbr15xUXkixHRyUs0PGBHrMQeCEsVPa7z4N55VDSIzKjRFcqMai1i3LfPhwRavhMN28ZCo4rnyh0Nyjicdwf6w5krmUguK13WSsGIwdDwH7Rqy2a8iQ0s0yhWXGsrUny05GVq1hwvMKcg2MASfKj6a7csLe5NPYX5BuIdfbFQSuLQ2jViwylwOhQUOqsqcYVVE0mra3MCa54hbs5K4ChOSmaUuNgmY1tn25j2aSfJp5MywnA4csDNd6AgdxvjdZr3OLIwiDL69r6O3dS4eNfWK4dTVsh3bT0XR8ZYcnvQ0A8YIHK9LjuYwVGomGcM2IRnwI4zR28APMWIithrHGGF5gyEWuhZLTJOfpegMUmDLziS4KeOjUiQZ0lJij1frdYqxowUu4RECiX9mBLMxx2mJRJf6dfHQ9pAxCGVxP4rKk3Bgyyhpu17iK2mjVuLCg9qnfpjBkhhCpFQ8iHXQ6g67rusAx9jmeGuPfSdxg1FgFG6X223dxEsKUlUJEhndb6eycnSQiovC5oWDiNTEmWK7YfmfBZP1HXaKLSLfmwy2Uhr68Td","dB"));
    }

    public String minWindow(String A, String B) {

        if(B.length() > A.length()){
            return "";
        }

        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(char b : B.toCharArray()){
            if(!freqMap.containsKey(b)){
                freqMap.put(b,1);
                continue;
            }
            freqMap.put(b,freqMap.get(b)+1);
        }
        int i=0,j=0,total = 0;
        while(i < A.length() && !freqMap.containsKey(A.charAt(i))){
            if(A.length() - i < B.length()){
                return "";
            }
            i++;
        }
        j = i;
        int min = Integer.MAX_VALUE;
        int low = -1;
        int high = -1;
        while(j < A.length()){
            char a = A.charAt(j);
            if(total == B.length()){
                if(freqMap.get(A.charAt(i)) == 0) {
                    if (freqMap.containsKey(a)) {
                        freqMap.put(a, freqMap.get(a) - 1);
                    }
                    j++;
                    continue;
                }


                while(i < j && (!freqMap.containsKey(A.charAt(i)) || freqMap.get(A.charAt(i)) < 0)){
                    if(freqMap.containsKey(A.charAt(i))){
                        freqMap.put(A.charAt(i),freqMap.get(A.charAt(i))+1);
                    }
                    i++;
                }
                int currentWinSize = j-i;
                if(min > currentWinSize){
                    min = currentWinSize;
                    high = j;
                    low = i;
                }
            }else{
                if(freqMap.containsKey(a)){
                    freqMap.put(a,freqMap.get(a) - 1);
                    if(freqMap.get(a) >= 0){
                        total++;
                        if(total == B.length()){
                            int currentWinSize = j-i+1;
                            if(min > currentWinSize){
                                min = currentWinSize;
                                high = j+1;
                                low = i;
                            }
                        }
                    }
                }
                j++;
            }
        }

        if(total < B.length()){
            return "";
        }
        while(i < j && (!freqMap.containsKey(A.charAt(i)) || freqMap.get(A.charAt(i)) < 0)){
            if(freqMap.containsKey(A.charAt(i))){
                freqMap.put(A.charAt(i),freqMap.get(A.charAt(i))+1);
            }
            i++;
        }
        int currentWinSize = j-i;
        if(min > currentWinSize){
            min = currentWinSize;
            high = j;
            low = i;
        }

        return A.substring(low,high);
    }
}

//            if(!freqMap.containsKey(a)){
//                j++;
//                continue;
//            }
//            int currentCharFreq = freqMap.get(a);
//            if(total == B.length()){
//                // check if removing char at ith position will keep the window
//                char atI = A.charAt(i);
//
//                if(freqMap.get(atI) == 0){
//                    j++;
//                    continue;
//                }
//                freqMap.put(atI,freqMap.get(atI)+1);
//                i++;
//            }else{
//                freqMap.put(a,--currentCharFreq);
//                if(freqMap.get(a) >= 0 && total < B.length()){
//                    total++;
//                }
//                j++;
//            }