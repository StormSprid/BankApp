package STORMSPRID;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("STORMSPRID");
        OperationConsoleListener consoleListener =  context.getBean(OperationConsoleListener.class);
        consoleListener.start();
        consoleListener.listenUpdates();
        consoleListener.close();


    }



}
