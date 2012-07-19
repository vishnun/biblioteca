package com.twu28.biblioteca;

import java.util.*;

public class User {
    private static Map<String,String> usernameToPasswordMap = new HashMap<String, String>();
    static {
        usernameToPasswordMap.put("111-1111","111-1111");
        usernameToPasswordMap.put("222-2222","222-2222");
        usernameToPasswordMap.put("333-3333","333-3333");
        usernameToPasswordMap.put("444-4444","444-4444");
        usernameToPasswordMap.put("555-5555","555-5555");
    }


    public static String authenticate(String username, String password) {
        Set userSet=usernameToPasswordMap.entrySet();
        for (Object aUser : userSet) {
            Map.Entry user = (Map.Entry) aUser;
            String currentUser = (String) user.getKey();
            if (!currentUser.equals(username)) continue;
            if (!user.getValue().equals(password)) throw new RuntimeException("Login Un-Successful");
            return currentUser;
        }
        throw new RuntimeException("Login Un-Successful");
    }
}
