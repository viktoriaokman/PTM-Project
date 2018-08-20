package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PTMUtils {

    /**
     * This solution convert different line breaks (like \r\n) to \n.
     *
     * @param is
     * @return
     */
    static String convertStreamToString(InputStream is) {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));

        try {
            String result = in.readLine();

            if (result.contains("done")) {
                result = result.substring(0, result.indexOf('\n'));
            }

            return result;
        }
        catch (Exception e)
        {
            return "";
        }

    }

    static byte[] convertStringToBytes(String str) {
        return str.getBytes();
    }
}
