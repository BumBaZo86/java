import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vad heter spelare ett? (X): ");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name, 'X');

        System.out.print("Vad heter spelare två? (O): ");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name, 'O');

        Game game = new Game(player1, player2);
        game.start();

        scanner.close();
    }
}

//Startar spelet