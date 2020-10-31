import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Board{
    static int SIZE = 11;
    Stack<Point_> stack = new Stack<>();
    public static Random rand = new Random();

    public char[][] generateMap() {
        char[][] board = new char[12][12];
        fillEmptyBoard(board);
        insertShips(board);
        return board;
    }

    public void insertShips(char[][] board) {
        insertShip(board, 4, 1);
        insertShip(board, 3, 2);
        insertShip(board, 2, 3);
        insertShip(board, 1, 4);
    }

    public void insertShip(char[][] board, int shipSize, int numberOfShips) {
        Point_ prev = new Point_(-1, -1);
        for (int i = 0; i < numberOfShips; i++) {
            while (stack.size() != shipSize) {
                stack.push(freeRandomPointToStart(board, prev));
                while (!stack.isEmpty() && stack.size() != shipSize) {
                    Stack<Point_> dir = createDirection();
                    boolean added = false;
                    while (!dir.isEmpty() && !added) {
                        Point_ currDir = dir.pop();
                        if (isFree(stack.peek()._x + currDir._x, stack.peek()._y + currDir._y, board, prev)) {
                            prev = stack.peek();
                            stack.push(new Point_(stack.peek()._x + currDir._x, stack.peek()._y + currDir._y));
                            added = true;
                        }
                    }
                    if (!added) {
                        stack.pop();
                    }
                }
            }
            markOnTheBoard(stack, board);
            stack.clear();
        }
    }

    public void markOnTheBoard(Stack<Point_> s, char[][] board) {
        while (!s.isEmpty()) {
            Point_ curr = s.pop();
            board[curr._x][curr._y] = '#';
        }
    }

    public Point_ freeRandomPointToStart(char[][] board, Point_ prev) {
        Point_ p = new Point_();
        while (!isFree(p._x, p._y, board, prev)) {
            p._x = rand.nextInt(10) + 1;
            p._y = rand.nextInt(10) + 1;
        }
        return p;
    }

    public boolean isFree(int posX, int posY, char[][] board, Point_ prev) {
        if (posX == SIZE || posY == SIZE) return false;
        if (posX == 0 || posY == 0) return false;
        if (posX == prev._x && posY == prev._y) return false;
        if (board[posX][posY] == '#') return false;
        if (board[posX + 1][posY] == '#') return false;
        if (board[posX][posY + 1] == '#') return false;
        if (board[posX + 1][posY + 1] == '#') return false;
        if (board[posX - 1][posY] == '#') return false;
        if (board[posX][posY - 1] == '#') return false;
        if (board[posX - 1][posY - 1] == '#') return false;
        if (board[posX - 1][posY + 1] == '#') return false;
        return board[posX + 1][posY - 1] != '#';
    }

    public Stack<Point_> createDirection() {
        Stack<Point_> dirStack = new Stack<>();
        dirStack.push(new Point_(0, 1));
        dirStack.push(new Point_(1, 0));
        dirStack.push(new Point_(0, -1));
        dirStack.push(new Point_(-1, 0));
        Collections.shuffle(dirStack);
        return dirStack;
    }

    public void fillEmptyBoard(char[][] board) {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    void display(char[][] board) {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        var board = new Board();
        board.display(board.generateMap());

    }

}