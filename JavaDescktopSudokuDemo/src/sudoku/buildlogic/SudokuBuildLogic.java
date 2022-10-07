package sudoku.buildlogic;

import java.io.IOException;

import sudoku.computationallogic.GameLogic;
import sudoku.userInterface.IUserInterfaceContract;
import sudoku.userInterface.logic.ControlLogic;
import sudoku.problemDomain.IStorage;
import sudoku.problemDomain.SudokuGame;

public class SudokuBuildLogic {
    
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        }
        catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
