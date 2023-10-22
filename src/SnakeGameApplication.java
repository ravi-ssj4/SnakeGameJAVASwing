
import snakedemo.userinterface.UserInterfaceImpl;

//*****************************************
public class SnakeGameApplication {

    public static void main(String[] args) {
        UserInterfaceImpl uiImpl = new UserInterfaceImpl();
        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
