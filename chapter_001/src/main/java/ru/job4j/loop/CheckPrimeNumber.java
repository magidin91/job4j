package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int finish) {
        boolean prime = true;
        for(int i=2; i<finish&&prime ;i++){
            if(finish%i==0)
                prime=false;
        }
        if(finish==1)
            prime=false;
        return prime;
    }
}