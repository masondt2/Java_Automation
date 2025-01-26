package execise1;
/*
Write a Java program to read and write a plain text file using
InputStream, OutputStream, FileInputStream, FileOutputStream.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWriteDemo {
    public static void main(String[] args) {
        String filePath = "example.txt";
        //writing
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            String data = "Hello, My name is Ngoc. This is my first Exercise.";
            fos.write(data.getBytes());
            System.out.println("Data written to the file is: " + data);
        } catch (IOException e) {
            System.out.println("Error write to file." + e.getMessage());
        }

        //Reading:
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int content;
            System.out.print("Data read from the file is: ");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
