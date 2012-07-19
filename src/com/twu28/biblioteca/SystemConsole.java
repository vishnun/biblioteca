package com.twu28.biblioteca;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemConsole implements Console {
    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public void println(int i) {
        System.out.println(i);
    }

    @Override
    public String readInput() {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "Cannot Take Input";
        }
    }

    @Override
    public String readPassword() {
        return readInput();
    }
}
