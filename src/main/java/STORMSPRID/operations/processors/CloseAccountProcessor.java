package STORMSPRID.operations.processors;

import STORMSPRID.operations.ConsoleOperationType;
import STORMSPRID.operations.OperationCommandProcessor;

public class CloseAccountProcessor implements OperationCommandProcessor {
    @Override
    public void processOperation() {

    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_CLOSE;
    }
}
