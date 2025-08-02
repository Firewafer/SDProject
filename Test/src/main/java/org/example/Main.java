package org.example;

import org.example.models.DBHelper;

public class Main {
    public static void main(String[] args) {

       /* SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("username", "shahid");
        editor.putBoolean("isLoggedIn", true);

        editor.apply(); */

        DBHelper.createTable(); // Ensure table exists
        new LoginTest();            // Start with Login window
    }

    public void checkForIslogin(){
        
    }
}