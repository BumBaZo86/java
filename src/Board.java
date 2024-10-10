public class Board {
    private char[] board;

    public Board() {
        board = new char[9];
        initializeBoard();
    }
//Definierar en klass som representerar spelet
    public void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }
//Metod för att skriva ut brädet
    public void printBoard() {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }
//Metod om brädet är fullt
    public boolean isFull() {
        for (char c : board) {
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }
//Metod för specifik placering av markeringar
    public boolean placeMark(int position, char mark) {
        if (position >= 1 && position <= 9 && board[position - 1] == ' ') {
            board[position - 1] = mark;
            return true;
        }
        return false;
    }
//Kontrollerar om spelare har vunnit
    public boolean checkWin(char mark) {
        // Kolla rader, kolumner och diagonaler
        return (board[0] == mark && board[1] == mark && board[2] == mark) || // Rad 1
                (board[3] == mark && board[4] == mark && board[5] == mark) || // Rad 2
                (board[6] == mark && board[7] == mark && board[8] == mark) || // Rad 3
                (board[0] == mark && board[3] == mark && board[6] == mark) || // Kolumn 1
                (board[1] == mark && board[4] == mark && board[7] == mark) || // Kolumn 2
                (board[2] == mark && board[5] == mark && board[8] == mark) || // Kolumn 3
                (board[0] == mark && board[4] == mark && board[8] == mark) || // Diagonal 1
                (board[2] == mark && board[4] == mark && board[6] == mark);   // Diagonal 2
    }
}