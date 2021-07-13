package com.test;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressDecompress {
    private static final String INPUT_FILE_TO_COMPRESS = "C:/hello.txt";
    private static final String INPUT_COMPRESS_FILE = "C:/prints.txt.gzip";

    public static void decompressGzip() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(INPUT_COMPRESS_FILE))));
        String s;
        while ((s = in.readLine()) != null)
            System.out.println(s);
        in.close();
    }

    public static void compressToGzip() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE_TO_COMPRESS));
        BufferedOutputStream zipOut = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(INPUT_FILE_TO_COMPRESS + ".gzip")));

        int c;
        while ((c = in.read()) != -1)
            zipOut.write(c);

        in.close();
        zipOut.close();
    }

    public static void main(String[] args) throws IOException {
        compressToGzip();
//                decompressGzip();
    }
}
