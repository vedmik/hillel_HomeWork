package org.example;

public class App{
    public static void main( String[] args ) {

        JewelsAndStones jewelsAndStones = new JewelsAndStones();

        System.out.println(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(jewelsAndStones.numJewelsInStones("z", "ZZ"));

        IdenticalPairs identicalPairs = new IdenticalPairs();

        System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,1,1,1}));
        System.out.println(identicalPairs.numIdenticalPairs(new int[]{1,2,3}));

    }
}
