package com.dgf.adevinta.component;

import com.dgf.adevinta.model.SearchResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchManager {

    private final FileIndexer fileIndexer;

    public SearchManager(FileIndexer fileIndexer) {
        this.fileIndexer = fileIndexer;
    }

    public void search(String line) {
        List<SearchResult> resPercent = new ArrayList<>();
        for (FileIndexed fileIndexed : fileIndexer.getIndexedFiles()) {
            final int result = fileIndexed.find(line);
            if (result>0) {
                resPercent.add(new SearchResult(result, fileIndexed.getFileName()));
            }
        }
        if (resPercent.size()==0) {
            System.out.println("No matches found");
        } else {
            resPercent.stream().sorted(Comparator.comparing(SearchResult::getPercent).reversed())
                    .limit(10)
                    .forEach(System.out::println);
        }
    }
}
