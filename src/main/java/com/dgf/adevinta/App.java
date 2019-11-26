package com.dgf.adevinta;

import com.dgf.adevinta.component.FileIndexer;
import com.dgf.adevinta.component.SearchManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class App {

    public static final String WORD_REGEXP = "\\W+";
    private final InputStream in;
    private final PrintStream out;

    public App() {
        this.in=System.in;
        this.out=System.out;
    }

//    public App(ByteArrayInputStream in, PrintStream out) {
//        this.in=in;
//        this.out=out;
//    }

    public void run(String file) throws IOException {
        FileIndexer fileIndexer = new FileIndexer(file);
        SearchManager searchManager = new SearchManager(fileIndexer);

        try (Scanner keyboard=new Scanner(in)) {
            do {
                out.print("search> ");
                final String line=keyboard.nextLine();
                if (":quit".equals(line)) break;
                searchManager.search(line);
            } while (true);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length==0) {
            throw new IllegalArgumentException("No directory given to index.");
        }
        new App().run(args[0]);
    }

}
