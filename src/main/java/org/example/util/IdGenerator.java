package org.example.util;

public class IdGenerator {
    private Integer currentId = 0;
    public Integer next() {
        return currentId++;
    }
}
