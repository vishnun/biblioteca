import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vishnun
 * Date: 7/14/12
 * Time: 7:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerMenu {
    private static ArrayList<String> menuList =new ArrayList<String>();
    CustomerMenu(){
        menuList.add("1. Show All Books");
        menuList.add("2. Reserve a Book");
        menuList.add("3. Verify Library number");
        menuList.add("4. Exit");
    }
    public void Display(Console consolestub) {
        for(String item: menuList)
            consolestub.println(item);
    }
}
