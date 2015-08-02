package model;

import java.io.*;

/**
 * Created by R2 on 01.08.2015.
 */
public class GamePlotParts {
    public static String start(){
        String text;
        try {
            text =  readTextFromFile("start.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }

    public static String introduction(){
        String text;
        try {
            text =  readTextFromFile("introduction.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }

    public static String part1(){
        String text;
        try {
            text =  readTextFromFile("part1.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }

    public static String part2(){
        String text;
        try {
            text =  readTextFromFile("part2.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }

    public static String part3(){
        String text;
        try {
            text =  readTextFromFile("part3.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }
    public static String part4(){
        String text;
        try {
            text =  readTextFromFile("part4.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }
    public static String part5(){
        String text;
        try {
            text =  readTextFromFile("part5.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }
    public static String part6(){
        String text;
        try {
            text =  readTextFromFile("part6.txt");
        } catch (IOException e) {
            text = "file can not read";
        }
        return text;
    }
    /**
     *
     * @return text in encoding is windows-1251
     * @throws IOException
     */
    private static String readTextFromFile(String title) throws IOException{

        File file = new File(title);
        BufferedReader fileIn = new BufferedReader(new FileReader(file)); // should check encoding
        String line;
        while ((line = fileIn.readLine()) != null) {
            if (!line.equals("$$")){
                System.out.println(line);
            }

        }
        fileIn.close();

        return line;
    }
}
