package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        int inX1 = 0;
        int inY1 = 0;
        int inX2 = 0;
        int inY2 = 4;
        int expected = 4;
        double out = Point.distance(inX1, inY1, inX2, inY2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance2() {
        int inX1 = 4;
        int inY1 = 0;
        int inX2 = 6;
        int inY2 = 0;
        int expected = 2;
        double out = Point.distance(inX1, inY1, inX2, inY2);
        Assert.assertEquals(expected, out, 0.01);
    }
}
