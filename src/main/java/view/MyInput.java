package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInput implements Input {

    @Override
    public String[] getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String [] inputWords;

        try {
            System.out.print("\n: ");
            input = reader.readLine().replaceAll("\\s+", " ").trim();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(input.isEmpty()){
            inputWords = new String[0];
        }else {
            inputWords = input.split("\\s");
        }

        return inputWords;
    }
}
