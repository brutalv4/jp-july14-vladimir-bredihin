package com.kademika.day13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by ricky on 11/1/14.
 */
public class InetPageContentDownloader {

    public static void main(String[] args) {

        URLConnection connection = null;
        try {
            URL url = new URL("http://kademika.com");
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Charset charset = Charset.forName("UTF-8");
        try (
                InputStream iStream = (InputStream) connection.getContent();
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("data.html"))
        ) {
            System.out.println("");
            int i = 0;
            byte[] buffer = new byte[1024];
            while (iStream.read(buffer) != -1) {
                writer.write(new String(buffer, charset));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}