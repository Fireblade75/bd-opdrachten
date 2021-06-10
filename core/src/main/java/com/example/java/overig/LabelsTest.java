package com.example.java.overig;

public class LabelsTest {
    public static void main(String[] args) {

        int c = 0;
        int v = 0;
        OUTER: while (c < 64) {
            PRINT:
            System.out.println("cv = " + c * v);
            INNER:
            while (v < 4 + c) {
                v++;
                if(Math.ceil(v / 32.0) == 0 && v != 0) {
                    break OUTER;
                }
                if(Math.ceil(v / 16.0)== 0 && v != 0) {
                    break INNER;
                }
                if(v == c &&  v != 0) {
                    v++;
                    c--;
                }
            }
            c += v / 2;
        }
    }
}
