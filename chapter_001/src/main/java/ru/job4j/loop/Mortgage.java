package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        double resultAmount=amount;
        int year=1;
        while(resultAmount*(1+percent/100)-salary>0){
            resultAmount=resultAmount*(1+percent/100)-salary;
            year++;
        }
        return year;
    }
}