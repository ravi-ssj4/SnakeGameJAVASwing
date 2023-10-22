package snakedemo.buildLogic;

public class SnakeGameBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException{
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try{
            System.out.println("DEBUG: before asking for game data from storage");
            initialState = storage.getGameData();
            System.out.println("DEBUG: after asking for game data from storage");
        } catch(IOException e){
            System.out.println("DEBUG: before asking for game data from GameLogic");
            initialState = GameLogic.getNewGame();
            System.out.println("DEBUG: after asking for game data from GameLogic");
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        // our task is to set the listener for action items(tiles in our case)
        // and update the new board with the GameState retrieved from the persisted game
        // probably played and saved previously or if not, then update the board with a new game
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
