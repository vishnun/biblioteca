import java.util.ArrayList;
public class CustomerMenu {
    private static ArrayList<String> menuList =new ArrayList<String>();
    CustomerMenu(){
        menuList.add("1. View All Books");
        menuList.add("2. Reserve a Book");
        menuList.add("3. Check Library number");
        menuList.add("4. Exit");
    }
    public void Display(Console consolestub) {
        for(String item: menuList)
            consolestub.println(item);
    }
}
