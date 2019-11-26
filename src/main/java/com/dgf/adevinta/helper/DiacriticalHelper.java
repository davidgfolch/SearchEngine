package com.dgf.adevinta.helper;

import java.text.Normalizer;

public class DiacriticalHelper {

    private static final String EMPTY = "";
    private static final String P_IN_COMBINING_DIACRITICAL_MARKS = "\\p{InCombiningDiacriticalMarks}+";

    public static String removeDiacriticalMarks(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD)
                .replaceAll(P_IN_COMBINING_DIACRITICAL_MARKS, EMPTY);
    }
}
