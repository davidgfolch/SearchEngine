package com.dgf.adevinta.component;

import java.io.File;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.dgf.adevinta.App.WORD_REGEXP;
import static com.dgf.adevinta.helper.DiacriticalHelper.removeDiacriticalMarks;

class FileIndexed {

    private final String file;
    private SortedSet<String> words = new TreeSet<>();

    FileIndexed(File file) {
        this.file=file.getName();
    }

    void index(String word) {
        words.add(removeDiacriticalMarks(word));
    }

    int find(String phrase) {
        final String[] words=phrase.split(WORD_REGEXP);
        int found=0;
        for (String word: words) {
            final String finalWord= removeDiacriticalMarks(word);
            if (this.words.contains(finalWord)) {
                found++;
            }
        }
        return (found==0?0:found*100/words.length);
    }

    String getFileName() {
        return this.file;
    }

}
