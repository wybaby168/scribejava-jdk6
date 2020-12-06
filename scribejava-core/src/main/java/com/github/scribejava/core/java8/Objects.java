package com.github.scribejava.core.java8;

public class Objects {

    public static int hashCode(Object o) {
        return o != null ? o.hashCode() : 0;
    }

    public static boolean equals(Object a, Object b) {
        return a == b || a != null && a.equals(b);
    }
}
