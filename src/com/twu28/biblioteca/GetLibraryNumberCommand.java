package com.twu28.biblioteca;

public class GetLibraryNumberCommand implements Command, LibraryObserver {
    private String currentUser="";

    public GetLibraryNumberCommand(Library library) {
        library.registerObserver(this);
    }

    @Override
    public void execute(Console console) {
        String librarianMessage="Please talk to Librarian. Thank you.";
        if(!currentUser.isEmpty()){
            console.println("Your Library Number is: "+currentUser);
            return;
        }
        console.println(librarianMessage);
    }

    @Override
    public void updateCurrentUserLoggedIn(String username) {
        this.currentUser=username;
    }
}
