import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Game {

    GameBoard gameBoard;

    private Mode gameMode;
    private boolean activePlayerIsPlayer1 = true;

    private Player player1;
    private Player player2;

    public Game(Mode mode, int boardSize) {

        gameMode = mode;
        gameBoard = new GameBoard(mode, boardSize, this);

        Location startingPositionForOne = new Location(0, (boardSize - 1) / 2);
        Location startingPositionForTwo = new Location(boardSize - 1, (boardSize - 1) / 2);

        switch (mode) {
        case TWO_PLAYER:
            player1 = new Player(true, startingPositionForOne, gameBoard);
            player2 = new Player(false, startingPositionForTwo, gameBoard);
            break;

        case ONE_PLAYER:
            player1 = new Player(true, startingPositionForOne, gameBoard);
            player2 = new PlayerBot(false, startingPositionForTwo, gameBoard);
            break;

        case BOT_BATTLE:
            player1 = new PlayerBot(true, startingPositionForOne, gameBoard);
            player2 = new PlayerBot(false, startingPositionForTwo, gameBoard);
            break;
        }
    }

    public Mode getMode() {
        return gameMode;
    }

    /**
     * Determining the current mode of the game with corresponding strings
     * 
     * @author mKals
     */
    public enum Mode {

        /* Mode is one of SINGLE_PLAYER, TWO_PLAYER, RESUME and MOVIE */

        TWO_PLAYER(0, "Two Player"), ONE_PLAYER(1, "One Player"), BOT_BATTLE(2, "Bot Battle");

        private final String text;

        private Mode(final int ID, final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }

    /**
     * Input from GUI calls this method
     * 
     * @param buttonLocation,
     *            the board location corresponding to the button triggering the
     *            input.
     */
    public void userInput(Location location) {

        Location previousLocation = null;

        if (activePlayerIsPlayer1) {

            if (player1.isValidMove(location, gameBoard)) {
                previousLocation = player1.getLocation();
                player1.moveTo(location, gameBoard);
            }

        } else {

            if (player2.isValidMove(location, gameBoard)) {
                previousLocation = player2.getLocation();
                player2.moveTo(location, gameBoard);
            }
        }

        if (previousLocation != null) {

            if (gameBoard.getGraph() != null) {

                for (Direction direction : Direction.values()) {
                    if (previousLocation.oneStep(direction).equals(location)) {
                        gameBoard.getGraph().moveMadeInDirection(direction);
                    }

                    break;
                }
            }
        }
        
        nextPlayersMove();
    }



    /**
     * Sets game state so to next players move If next player is bot, it makes
     * query for next players move and executes same If next player is human,
     * game will wait for input through GUI
     * 
     * Also checks whether game outcome is determined and terminates as soon as
     * this is the case
     */
    private void nextPlayersMove() {

        activePlayerIsPlayer1 = !activePlayerIsPlayer1;
        gameBoard.updateInfoPanelInUI(activePlayerIsPlayer1);

        if (activePlayerIsPlayer1) {
            if (player1 instanceof PlayerBot) {
                PlayerBot player = (PlayerBot) player1;
                Location playerMove = player.makeMove(player2.getLocation(), gameBoard);
                userInput(playerMove);
            }

        } else {
            if (player2 instanceof PlayerBot) {
                PlayerBot player = (PlayerBot) player2;
                Location playerMove = player.makeMove(player1.getLocation(), gameBoard);
                userInput(playerMove);
            }
        }

        if (isGameFinished()) {

            // TODO: handle game state when game is over
        }

        // if human, next input will be made by user
    }

    /**
     * determines if game is finished
     * 
     * @return weather or not game is finished
     */
    public boolean isGameFinished() {
        // TODO: implement
        if (getWinner() != null)
            return true;
        return false;
    }

    /**
     * 
     * @return the winner of the game
     */
    public Player getWinner() {

        // TODO: implement getting the winner once game is finished

        return null;
    }

    /*
     * public setBoard(Board board) {
     * 
     * //TODO: implement loading game from file }
     * 
     * public setPlayer(Player player) {
     * 
     * //TODO: implement loading game from file
     * 
     * }
     */

    void save() {

    }

    /**
     * Opens an already saved game specified by fileName. Parses the file
     * specified by fileName. If fileName is a valid game, it initializes a game
     * and simulates it up to the last move specified in the file.
     * 
     * @param fileName:
     *            an absolute path to the game file to be opened
     * @return true if file is valid game and opened successfully, false
     *         otherwise
     */
    public void open(String fileName) throws IOException {

        /* To save the game to the same file later if desired */
        this.fileName = fileName;

        /* Just the scanner code. */
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        // read file line by line
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            String line = scanner.next();
            /* … */
        }

        scanner.close();
    }

    private String fileName;

}
