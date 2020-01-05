package ru.job4j.other.lyambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        ArrayList<Double> out = new ArrayList<Double>();
        for (int i = start; i < end; i++) {
            out.add(func.apply((double) i));
        }
        return out;
    }
}
