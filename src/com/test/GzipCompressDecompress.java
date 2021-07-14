package com.test;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressDecompress {
    private static final String COMPRESSED_FILE = "C:/big.txt.gzip";
    private static final String FILE = "C:/big.txt";


    public static void unGzip() {
        long start = System.currentTimeMillis();
        byte[] buffer = new byte[2048];
        try (GZIPInputStream gZIPInput = new GZIPInputStream(new FileInputStream(COMPRESSED_FILE));
             FileOutputStream fileOutputStream = new FileOutputStream(FILE)){

            int bytes_read;
            while ((bytes_read = gZIPInput.read(buffer)) > 0)
                fileOutputStream.write(buffer, 0, bytes_read);

            double res = (double) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("The file was decompressed successfully in %.2f sec.%n", res);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void gZip() {
        long start = System.currentTimeMillis();
        byte[] buffer = new byte[2048];
        try (GZIPOutputStream gzipOuput = new GZIPOutputStream(new FileOutputStream(FILE + ".gzip"));
             FileInputStream fileInput = new FileInputStream(FILE)) {

            int bytes_read;
            while ((bytes_read = fileInput.read(buffer)) > 0) //в массив байтов buffer записываются данные
                gzipOuput.write(buffer, 0, bytes_read);

            double res = (double) (System.currentTimeMillis() - start) / 1000;
            System.out.printf("The file was compressed successfully in %.2f sec.%n", res);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        gZip();
    }
}