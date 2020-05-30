package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

/*
Everybody remembers this paper-and-pencil game from childhood:
Tic-Tac-Toe, also known as Noughts and crosses or Xs and Os.
A single mistake usually costs you the game,
But thankfully it is simple enough that most players discover the best strategy quickly.
This is a Tic-Tac-Toe game for two players!
 */


public class TicTacToe {
    private final char[][] board = new char[3][3];
    private char currentPlayerMark = 'X';
    //    private int xCount = 0;
    //    private int oCount = 0;
    //    private int emptyCell = 0;
    //    private int symbolCount = 0;
    private int winX = 0;
    private int winO = 0;
    private int countMoves = 0;

    public static void main(String[] args) {
        var game = new TicTacToe();
        game.initializeBoard();
        game.printBoard();
        game.makeMove();
    }

    public void initializeBoard() {
        for (char[] emptyCells : board) {
            Arrays.fill(emptyCells, '_');
        }
    }

    public void printBoard() {

        System.out.println("---------");
        for (char[] cells : board) {
            System.out.print("| ");
            for (char cell : cells) {
                System.out.print(cell + " ");
            }
            System.out.print(" |");
            System.out.println();

        }
        System.out.println("---------");
        System.out.println(currentPlayerMark + " Turn now");

    }

    public void makeMove() {
        while (!finishedGame()) {
            System.out.println("Enter the coordinates: ");
            Scanner scanner = new Scanner(System.in);
            int raw = scanner.nextInt();
            int col = scanner.nextInt();
            if (isValidMove(raw, col)) {
                board[raw - 1][col - 1] = currentPlayerMark;
                changePlayer();
                printBoard();
                countMoves++;
            }
        }
    }

    public boolean isValidMove(int raw, int col) {
        if (raw > 3 || col > 3 || raw <= 0 || col <= 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (board[raw - 1][col - 1] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    private boolean checkRowColDiag(char c1, char c2, char c3) {
        if ((c1 != '_') && (c1 == c2) && (c2 == c3)) {
            currentPlayerMark = c1;
            return true;
        } else {
            return false;
        }
    }

    public boolean finishedGame() {
        if (checkWinner()) {
            System.out.println(currentPlayerMark + " wins");
            return true;
        }
        if (isDraw()) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        return !checkWinner() && countMoves == 9;
    }

    public boolean checkWinner() {
        for (int i = 0; i < board.length; i++) {
            if ((checkRowColDiag(board[i][0], board[i][1], board[i][2]))) {
                if (board[i][0] == 'X') {
                    winX++;
                    return true;
                } else if (board[i][0] == 'O') {
                    winO++;
                    return true;
                }
            } else if (checkRowColDiag(board[0][i], board[1][i], board[2][i])) {
                if (board[0][i] == 'X') {
                    winX++;
                    return true;
                } else if (board[0][i] == 'O') {
                    winO++;
                    return true;
                }
            } else if ((checkRowColDiag(board[0][0], board[1][1], board[2][2]))
                    || (checkRowColDiag(board[0][2], board[1][1], board[2][0]))) {
                if (board[1][1] == 'X') {
                    winX++;
                    return true;
                } else if (board[1][1] == 'O') {
                    winO++;
                    return true;
                }
            }
        }
        return false;
    }
}
