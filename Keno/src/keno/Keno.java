/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author kostis
 */
public class Keno {

    static int amount = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose how many games you want to play: 2, 3, 4, 5,6,10,20,50,100,200");
        int games = sc.nextInt();
        sc.nextLine();
        System.out.println("Give your bet:1)Even 2)Odd 3)Draw");
        int bet = sc.nextInt();
        sc.nextLine();
        System.out.println("Give amount of money bet(euro): 1, 2, 3, 5, 10, 15, 20, 30, 50, 100");
        int moneyPerBet = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < games; i++) {
            amount = amount - moneyPerBet;
            if (amount >= 0) {
                int[] pinakasKlirosis = runaDraw();

                showNumbers(pinakasKlirosis);

                CalcEvenOdd(pinakasKlirosis, bet, moneyPerBet);
            } else {
                System.out.println("You do not have money");
                System.exit(0);
            }
        }
    }

    public static int[] runaDraw() {
        Set<Integer> klirosiSet = new HashSet<>();
        int[] pinakasKlirosis = new int[20];
        //int i=0;
        
        do {
            
            klirosiSet.add((int) ((Math.random() * 80) + 1));
            
        }while (klirosiSet.size() < 20);
        
       // for (Integer Klirosi : klirosiSet) {
          //  pinakasKlirosis[i] = Klirosi;
          //  i++;
       // }
       Iterator<Integer> itr = klirosiSet.iterator();
        for (int j = 0; j < pinakasKlirosis.length; j++) {
              pinakasKlirosis[j]  = itr.next();
        }

        return pinakasKlirosis;
    }

    public static void showNumbers(int[] pinakas) {

        for (int i = 0; i < pinakas.length; i++) {

            System.out.print(pinakas[i] + " ");

        }
        System.out.println("");
    }

    public static void CalcEvenOdd(int[] pinakas, int bet, int moneyPerBet) {
        int countEven = 0;
        int countOdd = 0;

        for (int i = 0; i < pinakas.length; i++) {
            if (pinakas[i] % 2 == 0) {
                countEven = countEven + 1;
            } else {
                countOdd = countOdd + 1;

            }
        }
        if (bet == 1 && (countEven > countOdd)) {

            amount = amount + (moneyPerBet * 2);
            System.out.println("You won " + (moneyPerBet * 2) + " euros! Most Numbers are Even");
            System.out.println("You have " + amount);

        } else if (bet == 2 && (countEven < countOdd)) {
            amount = amount + (moneyPerBet * 2);
            System.out.println("You won " + (moneyPerBet * 2) + " euros! Most Numbers are Odd");
            System.out.println("You have " + amount);

        } else if (bet == 3 && (countEven == countOdd)) {
            amount = amount + (moneyPerBet * 4);
            System.out.println("You won big time! " + (moneyPerBet * 4) + " euros! Numbers are equal");
            System.out.println("You have " + amount);
        } else {

            System.out.println("You lost big time!");
            System.out.println("You have " + amount);

        }
    }

}
