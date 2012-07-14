import java.util.ArrayList;

public class Library {

    private CustomerMenu menu=new CustomerMenu();
    private BookRepository bookRepository=new BookRepository();
    private CustomerList RegisteredCustomers=new CustomerList();
    public void showWelcomeMessage(Console console) {
        console.println("Welcome to the Library");
    }

    public void DisplayMenu(Console console) {
        menu.Display(console);
    }

    public void selectOption(int option, Console console) {
        switch (option){
            case 1:
                ArrayList <String> listOfBooks=bookRepository.DisplayAllBooks();
                for (String listOfBook : listOfBooks)
                    console.println(listOfBook);
                break;
            case 2:
                console.println("Enter The Book Name: ");
                String bookname=console.GetUserInput();
                //String bookname="Head First Java";
                Book bookToReserve;
                try{
                    bookToReserve=bookRepository.GetBook(bookname);
                }catch (Exception bookNotFound){
                    console.println(bookNotFound.toString());
                    return;
                }
                console.println("Enter your Customer ID: ");
                String customerId=console.GetUserInput();
                //String customerId="1";
                Customer customer=null;
                try{
                    customer = RegisteredCustomers.GetCustomer(Integer.parseInt(customerId));
                }catch (Exception customerNotRegistered){
                    console.println(customerNotRegistered.toString());
                }
                String message=Register.ReserveBook(bookToReserve,customer);
                console.println(message);
                break;
            case 3:
                console.println("Valid Option");
                break;
            case 4:
                console.println("Valid Option");
                break;
            default:
                console.println("Please select a Valid Option");
        }
    }
}