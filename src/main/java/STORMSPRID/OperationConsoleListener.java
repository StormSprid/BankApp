package STORMSPRID;


import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class OperationConsoleListener {

    private final Scanner scanner;
    private final Map<ConsoleOperationType, OperationCommandProcessor> processorMap;

    public OperationConsoleListener(
            Scanner scanner,
            List<OperationCommandProcessor> processorList


    ) {
        this.scanner = scanner;

        this.processorMap = processorList
                        .stream()
                        .collect(Collectors.toMap(
                                OperationCommandProcessor::getOperationType,
                                processor -> processor
                        ));
    }



    public void listenUpdates() {

        while (!Thread.currentThread().isInterrupted()) {
            var operationType = listenNextOperation();
            if (operationType==null){
                return;
            }
            processNextOperation(operationType);
        }


    }

    private ConsoleOperationType listenNextOperation() {
        System.out.println("Type next operation: ");
        printAllAvailableOperations();
        while (!Thread.currentThread().isInterrupted()) {
            var nextOperation = scanner.nextLine();
            try {
                return ConsoleOperationType.valueOf(nextOperation);
            } catch (IllegalArgumentException e) {
                System.out.println("No such command found");
            }

        }
        return null;
    }

    private void printAllAvailableOperations() {
        processorMap.keySet().forEach(System.out::println);
    }

    private void processNextOperation(ConsoleOperationType operationType) {
        try {
            var processor = processorMap.get(operationType);
            processor.processOperation();


        } catch (Exception e) {
            System.out.printf("Error executing command:%s,error: %s%n",
                    operationType,
                    e.getMessage());
        }
    }
    public void start(){
        System.out.println("Console Listener Started>>>");
    }
    public void close(){
        System.out.println("Console Listener Closed<<<");
    }
}

