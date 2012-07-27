package com.twu28.biblioteca;

public class LibraryApplication {
    public static void main(String args[]){
        Library library=new Library();
        Console console=new SystemConsole();
        int EXIT=6;
        while(true){
            console.println("\n****************************");
            library.showWelcomeMessage(console);
            console.println("****************************");
            library.displayMenu(console);
            console.println("Enter your Choice: ");
            int option=0;
            try{
                option=Integer.parseInt(console.readInput());
            }catch (Exception ignored){
            }
            library.selectOption(option,console);
            if(option==EXIT)break;
        }
    }
}