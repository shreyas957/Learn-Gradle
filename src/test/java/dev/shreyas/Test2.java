package dev.shreyas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {
    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(5000);
        assertEquals(2, 10/5);
    }
}
