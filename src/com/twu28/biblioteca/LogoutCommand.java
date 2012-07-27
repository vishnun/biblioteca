package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class LogoutCommand implements Command,LibraryObserver {
    private String currentUser="";
    private List<LoginAndLogoutCommandObserver> observers =new ArrayList<LoginAndLogoutCommandObserver>();

    public LogoutCommand(Library library) {
        registerObserver(library);
    }

    private void registerObserver(Library library){
        library.registerObserver(this);
        this.observers.add(library);
    }

    @Override
    public void execute(Console console) {
        if(currentUser.isEmpty()){
            console.println("You need to login first.");
            return;
        }
        console.println("Logged Out");
        currentUser="";
        notifyUserLoggedOutToObservers(currentUser);
    }

    private void notifyUserLoggedOutToObservers(String username) {
        for (LoginAndLogoutCommandObserver observer : observers) {
            observer.updateLoginStatus(username);
        }
    }

    @Override
    public void updateCurrentUserLoggedIn(String username) {
        this.currentUser=username;
    }
}
