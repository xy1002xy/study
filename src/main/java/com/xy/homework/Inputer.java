package com.xy.homework;

/**
 * @program: sell
 * @author: wxy
 * @create: 2018-04-16 20:45
 * @desc:
 **/
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inputer {
    protected Console console = System.console();
    protected String input = "";

    public Inputer() {
        // TODO Auto-generated constructor stub
    }

    public String getInput() {
        if (console != null) {
            input = console.readLine();
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("BufferedReader Error");
                e.printStackTrace();
            }
			/*// this is only if the object is to be used once!!
			 * finally { try { reader.close(); } catch(IOException e) {
			 * e.printStackTrace(); } }
			 */
        }
        return input;
    }

}

