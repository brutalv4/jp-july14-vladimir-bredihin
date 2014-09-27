package com.kademika.day11.frame11charCharsetsEncoding;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ricky on 28.07.14.
 */
public class ChangeEncodingDemo {

    public static void main(String[] args) {
        String fileName = "test_copy.txt";
        File file = new File(fileName);

        changeEncoding(file, "CP1251", "UTF8");
    }

    public static void changeEncoding(File file, String curEncoding, String newEncoding) {
        if (file.exists()) {
            StringBuilder builder = new StringBuilder();

//            read section
            try (
                    // input
                    FileInputStream fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, curEncoding);
                    BufferedReader reader = new BufferedReader(inputStreamReader)
            ) {
                String tmp;
                while ((tmp = reader.readLine()) != null) {
                    builder.append(tmp);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

//           write section
            try (
                    // output
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, newEncoding);
            ) {
                writer.write(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
