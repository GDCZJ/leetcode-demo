package com.czj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(myPow(2, -1));
    }

    public static double myPow(double x, int n) {
        if (n==0) {
            return 1;
        } else if (n < 0) {
            return 1/myPow2(x, -n);
        } else {
            return myPow2(x, n);
        }
    }

    public static double myPow2(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return myPow2(x, n/2) * myPow2(x, n/2);
        } else {
            return x * myPow2(x, n - 1);
        }
    }

}
