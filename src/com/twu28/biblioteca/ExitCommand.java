package com.twu28.biblioteca;
public class ExitCommand implements Command {
    @Override
    public void execute(Console console) {
        console.println("Thank you. Visit again soon.");
    }
}
