import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        while (!gameWon && !board.isFull()) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getMarker() + "), vilken ruta (1-9)?");
            int position = scanner.nextInt();

            if (board.placeMark(position, currentPlayer.getMarker())) {
                gameWon = board.checkWin(currentPlayer.getMarker());
                if (!gameWon) {
                    switchPlayer();
                }
            } else {
                System.out.println("Ogiltigt drag, försök igen.");
            }
        }
        board.printBoard();
        if (gameWon) {
            System.out.println("Grattis " + currentPlayer.getName() + ", du har vunnit!");
        } else {
            System.out.println("Det blev oavgjort!");
        }
    }
    //Metod ansvarar för att köra huvudloopen i spelet. Växlar spelare, ber om drag och uppdaterar brädet, om någon vunnit

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
//Metod som ansvarar för att byta tur mellan spelarna.