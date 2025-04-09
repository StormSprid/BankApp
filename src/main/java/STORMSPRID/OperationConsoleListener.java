package STORMSPRID;

import java.util.Scanner;

public class OperationConsoleListener {

    private Scanner scanner;

    public OperationConsoleListener(Scanner scanner) {
        this.scanner = scanner;
    }



    public void listenUpdates(){
        while(true){
            System.out.println("Type next operation:\n");
            String nextLine = scanner.nextLine();
            switch (nextLine) {
                case "USER_CREATE":
                    System.out.println("User created!");
                    break;
                case "ACCOUNT_CREATE":
                    System.out.println("Account created!");
                    break;
                default:
                    System.out.println("Invalid Operation");
            }
        }

    }


}
