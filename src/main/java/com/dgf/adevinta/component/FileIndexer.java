package com.dgf.adevinta.component;

import com.dgf.adevinta.helper.Metrics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.dgf.adevinta.App.WORD_REGEXP;

public class FileIndexer {

    private List<FileIndexed> indexedFiles = new ArrayList<>();

    public FileIndexer(String folderPath) throws IOException {
        final File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, filename) -> filename.endsWith(".txt"));
        if (files == null) {
            throw new FileNotFoundException("No text files found in folder: " + folderPath);
        }
        System.out.println(files.length+" file(s) found in "+folderPath);
        for (File file : files) {
            indexFiles(file);
        }
    }

    private void indexFiles(File file) throws IOException {
        FileIndexed fileIndexed = new FileIndexed(file);
        Metrics metrics = new Metrics();
        try (LineNumberReader in = new LineNumberReader(new InputStreamReader(new FileInputStream(file)))) {
            do {
                final String line = in.readLine();
                if (line == null) {
                    break;
                }
                String[] words = line.toLowerCase().split(WORD_REGEXP);
                for (final String word : words) {
                    fileIndexed.index(word);
                }
            } while (true);
        }
        indexedFiles.add(fileIndexed);
        System.out.println("indexed in "+metrics.end()+" nanoseconds file: "+file.getName());
    }

    public List<FileIndexed> getIndexedFiles() {
        return indexedFiles;
    }

}
