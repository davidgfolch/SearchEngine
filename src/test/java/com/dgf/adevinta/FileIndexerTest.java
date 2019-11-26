package com.dgf.adevinta;

import com.dgf.adevinta.component.FileIndexer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileIndexerTest {

    @Test()
    public void getIndexedFiles() throws IOException {
        FileIndexer fm = new FileIndexer("src/test/resources");
        assertEquals(1,fm.getIndexedFiles().size());
    }

}
