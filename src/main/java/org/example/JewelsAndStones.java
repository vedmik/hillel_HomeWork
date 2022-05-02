package org.example;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int sum = 0;

        char[] arrayJewels = jewels.toCharArray();
        char[] arrayStones = stones.toCharArray();

        for (int i = 0; i < arrayJewels.length; i++) {
            for (int j = 0; j < arrayStones.length; j++) {
                if(arrayJewels[i] == (arrayStones[j])){
                    sum++;
                }
            }
        }

        return sum;
    }
}
