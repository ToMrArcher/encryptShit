package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void decrypt(ArrayList<String> lines, int cipher){
        for(int i = 0; i < lines.size(); i++){
            char[] chars = lines.get(i).toCharArray();
            for(var y = 0; y < chars.length; y++) {
                chars[y] -= cipher;
            }
            lines.set(i, String.valueOf(chars));
        }
    }

    public static void encrypt(ArrayList<String> lines, int cipher){
        for(int i = 0; i < lines.size(); i++){
            char[] chars = lines.get(i).toCharArray();
            for(var y = 0; y < chars.length; y++) {
                chars[y] += cipher;
            }
            lines.set(i, String.valueOf(chars));
        }
    }

    public static void writeFile(ArrayList<String> lines, String fileName) throws IOException {
        File file = new File(fileName);
        file.delete();
        file.createNewFile();

        FileWriter myWriter = new FileWriter(fileName);
        for(String line: lines){
            myWriter.write(line);
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }

    public static void openFile(ArrayList<String> falseLines) throws FileNotFoundException {
        Scanner falseScanner = new Scanner(System.in);
        String fileName = falseScanner.nextLine();
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (!line.isEmpty()) {
                falseLines.add(line);
            }

        }
    }

    public static void main(String[] args) throws IOException {

        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(true){
            int input = Integer.valueOf(scanner.nextLine());
            if(input == -1){
                break;
            }
            switch (input){
                case 1:
                    openFile(lines);
                    break;
                case 2:
                    writeFile(lines, "output.txt");
                    break;
                case 3:
                    encrypt(lines, 20);
                    break;
                case 4:
                    decrypt(lines, 20);
                    break;
                default:
                    break;
            }
        }

        encrypt(lines, 20);

    }
}