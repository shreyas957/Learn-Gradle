package dev.shreyas;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MainTest {
    @Test
    public void testSayHello() throws IOException {
        Main.main(new String[]{"en"});
    }
}
