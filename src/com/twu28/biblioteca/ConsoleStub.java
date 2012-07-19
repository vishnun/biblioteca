package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.List;

//try not to mix business logic

public class ConsoleStub implements Console {
    private final List<String> lines = new ArrayList<String>();
    private List<String> inputList =new ArrayList<String>();

    public String getLine(int lineNumberOneBased) {
        return lines.get(lineNumberOneBased - 1);        //console to the test
    }

    @Override
    public void println(String s) {   //object to console
        lines.add(s);
    }

    @Override
    public void println(int i) {
        lines.add(String.valueOf(i));
    }

    @Override
    public String readInput() {
        return inputList.remove(0);
    }

    @Override
    public String readPassword() {
        return readInput();
    }

    public void InitializeInputSequence(ArrayList<String> inputListOrder) {
        for (String input : inputListOrder) {
            inputList.add(input);
        }
    }
}