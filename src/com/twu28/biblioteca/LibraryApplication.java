package com.twu28.biblioteca;

public class LibraryApplication {
    public static void main(String args[]){
        Library library=new Library();
        Console console=new SystemConsole();
        while(true){
            console.println("\n****************************");
            library.showWelcomeMessage(console);
            console.println("****************************");
            library.DisplayMenu(console);
            console.println("Enter your Choice: ");
            int option=0;
            try{
                option=Integer.parseInt(console.GetUserInput());
            }catch (Exception e){
            }
            library.selectOption(option,console);
            if(option==5)break;
        }
    }
}