package dev.muneer.movies.helper;

public class DebugUtil {

    public static void varDump(Object value) {
        if(value == null){
        System.out.println("Debug Info: " + value);
        }
        else{
            System.out.println("Debug Info: " + value.toString());
        }
        System.exit(0); // Exit the program (for debugging purposes)
    }
}