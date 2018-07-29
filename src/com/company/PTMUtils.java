package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class PTMUtils {

    /**
     * This solution convert different line breaks (like \r\n) to \n.
     *
     * @param is
     * @return
     */
    static String convertStreamToString(InputStream is) {
        String result = new BufferedReader(new InputStreamReader(is)).lines()
                .parallel().collect(Collectors.joining("\n"));
        return result;
    }

    static byte[] convertStringToBytes(String str) {
        return str.getBytes();
    }
}
