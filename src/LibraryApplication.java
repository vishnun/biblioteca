/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/14/12
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryApplication {
    public static void main(String args[]){
        Library library=new Library();
        Console console=new SystemConsole();

        while(true){
            library.showWelcomeMessage(console);
            console.println("****************************");
            library.DisplayMenu(console);
            console.println("\nEnter your Choice: ");
            int option=0;
            try{
                option=Integer.parseInt(console.GetUserInput());
            }catch (Exception e){
                console.println("Invalid Option");
            }
            library.selectOption(option,console);
            if(option==4)break;
        }
    }
}
