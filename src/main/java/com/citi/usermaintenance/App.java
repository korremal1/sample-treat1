package com.citi.usermaintenance;

import com.citi.usermaintenance.process.UserProcessor;

/**
 * App class -> starting point
 */
public class App {


    public static void main(String str[]) throws Exception{

        UserProcessor processor = new UserProcessor();
        processor.process();
    }
}
