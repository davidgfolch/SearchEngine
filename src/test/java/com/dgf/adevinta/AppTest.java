package com.dgf.adevinta;

import org.junit.Test;

import java.io.IOException;
import java.util.NoSuchElementException;

public class AppTest {

    @Test(expected = IOException.class)
    public void fileNotFound() throws IOException {
        App app = new App();
        app.run("xx");
    }

    @Test(expected = NoSuchElementException.class) //scanner No line found
    public void fileFound() throws IOException {
        App app = new App();
        app.run("src/test/resources");
    }

//    @Test() //todo java.util.NoSuchElementException: No line found
//    public void scanner() throws IOException {
//        ByteArrayInputStream in = new ByteArrayInputStream("input text".getBytes());
//        PrintStream out = new PrintStream(new ByteArrayOutputStream());
//        App app = new App(in,out);
//        app.run("src/test/resources");
//        assertFalse(out.checkError());
//    }

}
