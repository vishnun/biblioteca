package com.twu28.biblioteca;
import java.util.ArrayList;
public class CustomerMenu {
    private static ArrayList<String> menuList =new ArrayList<String>();
    CustomerMenu(){
        menuList.add("1. Login");
        menuList.add("2. View All Books");
        menuList.add("3. Reserve a Book");
        menuList.add("4. Check Library number");
        menuList.add("5. View All Movies");
        menuList.add("6. Exit");
        menuList.add("7. Logout");
    }
    public void display(Console consolestub) {
        for(String item: menuList)
            consolestub.println(item);
    }
}