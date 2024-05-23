import java.util.Scanner;
/*
public class RoomsAttempt {
    private static final int MAP_SIZE = 3;
    private static final char EMPTY_TILE = '.';
    private static final char PLAYER_TILE = '@';

    private static int playerX = 0;
    private static int playerY = 0;

    private static char[][] map = new char[MAP_SIZE][MAP_SIZE];

    public static void main(String[] args) {

        initializeMap();
        displayMap();


        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print("Enter Direction (Move Forward /Move Back/Move Left/Move Right) \n"  );
            input = scanner.nextLine().toUpperCase();
            movePlayer(input);
            displayMap();
        }
    }
    private static void initializeMap(){
        for (int i =0; i<MAP_SIZE; i++){
            for (int j=0; j<MAP_SIZE; j++){
                map[i][j] = EMPTY_TILE;
            }
        }
        map[playerY][playerX] = PLAYER_TILE;
    }

    private static void displayMap(){
        for (int i =0; i<MAP_SIZE; i++){
            for (int j =0; j<MAP_SIZE;j++){
                System.out.print(map[i][j] + "");
            }
            System.out.println();
        }

    }


    private static void movePlayer(String direction) {
        direction = direction.trim().toUpperCase();
        System.out.println("Input direction: " + direction);

        switch (direction) {
            case "MOVE BACK":
                if (playerY > 0) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerY--;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE LEFT":
                if (playerX > 0) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerX--;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE FORWARD":
                if (playerY < MAP_SIZE - 1) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerY++;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE RIGHT":
                if (playerX < MAP_SIZE - 1) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerX++;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
        }
    }
}*/
import java.util.Scanner;

public class RoomsAttempt {
    private static final int MAP_SIZE = 3;
    private static final char EMPTY_TILE = '.';
    private static final char PLAYER_TILE = '@';

    private static int playerX = 0;
    private static int playerY = 0;

    private static char[][] map = new char[MAP_SIZE][MAP_SIZE];

    public static void initializeMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_TILE;
            }
        }
        map[playerY][playerX] = PLAYER_TILE;
    }

    public static void displayMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void movePlayer(String direction) {
        direction = direction.trim().toUpperCase();
        System.out.println("Input direction: " + direction);

        switch (direction) {
            case "MOVE BACK":
                if (playerY > 0) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerY--;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE LEFT":
                if (playerX > 0) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerX--;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE FORWARD":
                if (playerY < MAP_SIZE - 1) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerY++;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
            case "MOVE RIGHT":
                if (playerX < MAP_SIZE - 1) {
                    map[playerY][playerX] = EMPTY_TILE;
                    playerX++;
                    map[playerY][playerX] = PLAYER_TILE;
                }
                break;
        }
    }
}


