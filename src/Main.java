package com.company;

import java.io.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader fr = new BufferedReader(new FileReader("C://lb13/src/fjk.txt"))) {
            int r = 0;
            String text = "";
            while ((r = fr.read()) != -1) {
                text += (char) r;
            }
            int value = text.indexOf("//");
            int value2 = text.indexOf("\n",value);
            StringBuffer op = new StringBuffer(text);
            op.delete(value, value2);

            int value3 = op.indexOf("/*");
            int value4 = op.lastIndexOf("*/");

            StringBuffer hh = new StringBuffer(op);
            hh.delete(value3, value4 + 2);
            System.out.println(hh);

            try (FileWriter fww = new FileWriter("C:///lb13/src/fjk2.txt");
                 BufferedWriter ad = new BufferedWriter(fww)){
                ad.write(hh.toString());
            } catch (IOException ex){
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}