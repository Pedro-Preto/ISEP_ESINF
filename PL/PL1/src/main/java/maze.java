import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class maze {
    private static final Scanner in = new Scanner(System.in);
    private static final Formatter out = new Formatter(System.out);


    private static final int MAXIMO_LINHAS_FILAS = 6;
    private static final int MAXIMO_COLUNAS_COLUNAS = 13;
    private static final String FICHEIRO = "maze.txt";

    public static void main(String[] args) {

        int maze[][] = new int[MAXIMO_LINHAS_FILAS][MAXIMO_COLUNAS_COLUNAS];
        preencherLabirinto(FICHEIRO, maze);

        out.format("\n");
        out.format("New Maze\n");

        for (int[] s : movements(maze, 0, 0)) {
            out.format(Arrays.toString(s) + "\n");
        }


    }


    private static boolean moveIsAllowed(int[][] maze, int y, int x) {

        return ((y >= 0) && (x >= 0) && (y < maze.length) && (x < maze[0].length) && (maze[y][x] == 1));

    }

    public static int[][] movements(int[][] maze, int y, int x) {
        maze[y][x] = 9;

        if ((y == maze.length - 1) && (x == maze[0].length)) return maze;

        int[][] result;
        if (moveIsAllowed(maze, y - 1, x)) {
            result = movements(maze, y - 1, x);//North
            if (result != null) return result;
        }
        if (moveIsAllowed(maze, y, x + 1)) {
            result = movements(maze, y, x + 1);//East
            if (result != null) return result;
        }
        if (moveIsAllowed(maze, y + 1, x)) {
            result = movements(maze, y + 1, x);//South
            if (result != null) return result;
        }
        if (moveIsAllowed(maze, y, x - 1)) {
            result = movements(maze, y, x - 1);//West
            if (result != null) return result;
        }
        maze[y][x] = 2;
        return maze;
    }

    public static int[][] preencherLabirinto(String nomeFicheiro, int[][] maze) {
        int contadorDeLinhas = 0;

        try (Scanner sc = new Scanner(new FileReader(nomeFicheiro))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha != null) {
                    String[] auxiliarDados = linha.split(" ");
                    if (auxiliarDados.length == MAXIMO_COLUNAS_COLUNAS) {
                        inserirRegisto(maze, contadorDeLinhas, auxiliarDados);
                        contadorDeLinhas++;
                    }
                }

            }
            for (int[] s : maze) {
                out.format(Arrays.toString(s) + "\n");
            }
            return maze;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void inserirRegisto(int[][] sala, int contadorDeLinhas, String[] auxiliarDados) {

        for (int i = 0; i < MAXIMO_COLUNAS_COLUNAS; i++)
            sala[contadorDeLinhas][i] = Integer.parseInt(auxiliarDados[i]);

    }
}
