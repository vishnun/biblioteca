package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class LoginCommand implements Command {
    private String librarian;
    private List<LoginAndLogoutCommandObserver> observerAndLogouts =new ArrayList<LoginAndLogoutCommandObserver>();

    public LoginCommand(Library library, String librarian) {
        this.librarian=librarian;
        registerObserver(library);
    }

    private void registerObserver(Library library){
        this.observerAndLogouts.add(library);
    }

    @Override
    public void execute(Console console) {
        console.println("Enter Your username: ");
        String username=console.readInput();
        console.println("Enter Your password: ");
        String password = console.readPassword();
        String currentUser="";
        try{
            currentUser = Register.authenticate(username, password);
            displayLoginMessage(console, currentUser);

        }catch (Exception unsuccessfullogin){
            console.println(unsuccessfullogin.getMessage());
            currentUser="";
        }
        notifyUserLoggedInToObservers(currentUser);
    }

    private void displayLoginMessage(Console console, String currentUser) {
        if(currentUser.equals(librarian)){
            console.println("Welcome Librarian.");
            return;
        }
        console.println("Login Successful");
    }

    private void notifyUserLoggedInToObservers(String username) {
        for (LoginAndLogoutCommandObserver observerAndLogout : observerAndLogouts) {
            observerAndLogout.updateLoginStatus(username);
        }
    }
}
