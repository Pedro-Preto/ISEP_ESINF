package app;

import app.Services.Data;
import app.controller.ReadFilesController;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Formatter out = new Formatter(System.out);


    public static void main(String[] args) throws FileNotFoundException {
        ReadFilesController readFilesController = new ReadFilesController();
        int opcao = 0;
        do {
            System.out.println();
            System.out.println();
            out.format("1 - Construir os grafos a partir da informação fornecida nos ficheiros de texto\n");
            out.format("2 - Devolver os amigos comuns entre os n utilizadores mais populares da rede\n");
            out.format("3 - Verificar se a rede de amizades é conectada.\n");
            out.format("4 - Devolver para um utilizador os amigos que se encontrem nas proximidades\n");
            out.format("5 - Devolver as n cidades com maior centralidade\n");
            out.format("6 - Devolver o caminho terrestre mais curto entre dois utilizadores\n");
            out.format("0 - SAIR\n");

            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    readFilesController.load();
                    break;
                case 2:
                    System.out.println("Insira o numero de amigos comuns");
                    int n = in.nextInt();
                    Data.getInstance().getCommonFriends(n);
                    break;
                case 3:
                    Data.getInstance().numMinOfEdgesBTWUsers();
                    break;
                case 4:
                    Data.getInstance().getCloseFriends("u1", 2);
                    break;
                case 5:
                    Data.getInstance().getCentralCities(2, 5);
                    break;
                case 6:
                    Data.getInstance().getShortPathBetweenUsers("u1", "u2", 2);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção não é válida\n");
                    break;
            }
        } while (opcao != 0);
    }

}
