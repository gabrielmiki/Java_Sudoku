package sudoku.userInterface;

public interface IUserInterfaceContract {
    interface EventListener {
        void onSudokuInput(int x, int, y, int input);
        void onDialogClick();
    }

    interface View {
        void setListener(IUserInterfaceContract.EnevntListener setListener);
        void updateSquare(SudokuGame game);
        void updateBoard(sudoku game);
        void showDialog(String Message);
        void showError(String message);
    }
}
