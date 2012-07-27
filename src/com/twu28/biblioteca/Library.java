package com.twu28.biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Library implements LoginAndLogoutCommandObserver {

    private Register register=new Register();
    private String currentUser;
    private CustomerMenu menu=new CustomerMenu();
    private BookRepository bookRepository=new BookRepository();
    private MovieCollection movieCollection= new MovieCollection();
    private List<LibraryObserver> libraryObservers=new ArrayList<LibraryObserver>();

    private List<Command> menuActions=new ArrayList<Command>();

    public Library(){
        addMenuActions();
        currentUser = "";
    }

    private void addMenuActions() {
        String librarianUsername = "111-1111";
        menuActions.add(new LoginCommand(this, librarianUsername));
        menuActions.add(new DisplayAllBooksCommand(bookRepository));
        menuActions.add(new BookReservationCommand(bookRepository));
        menuActions.add(new GetLibraryCommand(this));
        menuActions.add(new DisplayAllMoviesCommand(movieCollection));
        menuActions.add(new ExitCommand());
        menuActions.add(new LogoutCommand(this));
    }

    private void notifyUserLoggedInToObservers(String username) {
        for (LibraryObserver observer : libraryObservers) {
            observer.updateCurrentUserLoggedIn(username);
        }
    }

    private boolean isInvalidOption(int option) {
        return (option-1) < 0 || (option-1) >=menuActions.size();
    }

    public void selectOption(int option, Console console) {
        if(isInvalidOption(option)){
            console.println("Select a valid option!!");
            return;
        }
        Command command=menuActions.get(option-1);
        command.execute(console);
        notifyUserLoggedInToObservers(currentUser);
    }

    @Override
    public void updateLoginStatus(String username) {
        this.currentUser=username;
    }

    public void registerObserver(LibraryObserver observer) {
        this.libraryObservers.add(observer);
    }

    public void showWelcomeMessage(Console console) {
        console.println("Welcome to the Library");
    }

    public void displayMenu(Console console) {
        menu.display(console);
    }
}