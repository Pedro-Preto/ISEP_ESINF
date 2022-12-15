import Controller.ReadFilesController;
import Services.Data;
import Solutions.FindByX;
import Services.TreeBuilder;

import java.util.Formatter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author pedro
 */
public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Formatter out = new Formatter(System.out);

    public static void main(String[] args) {
        int opcao;
        ReadFilesController controller = new ReadFilesController();
        controller.load();
        do {
            System.out.println();
            out.format("1.Pesquisa de elementos por qualquer um dos seguintes campos\n");
            out.format("2.Pesquisa por intervalo de valores de Atomic Mass Através de dois valores (mínimo e máximo)\n");
            out.format("3.Devolva por ordem decrescente as configurações electrónicas com mais do que uma repetição agrupadas por número de repetições\n");
            out.format("4.Construa uma nova BST inserindo por ordem decrescente as configurações electrónicas \n");
            out.format("5.Devolver os valores das duas configurações electrónicas mais distantes na árvore e a respectiva distância \n");
            out.format("0/ SAIR\n");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    showMenu(Data.getInstance().treeBuilder());
                    break;
                case 2:
                    System.out.println("Insert Limit 1");
                    int limit1 = in.nextInt();
                    System.out.println("Insert Limit 2");
                    int limit2 = in.nextInt();
                    System.out.println();
                    Data.getInstance().getElementByAtomicMassInCertainLimit(Data.getInstance().treeBuilder().getTreeAtomicMass(), limit1, limit2);
                    break;
                case 3:
                    Data.getInstance().getDecrescenteElectronicConfig(Data.getInstance().treeBuilder().getTreeAtomicNumber());
                    break;
                case 4:
                    Data.getInstance().newBST(Data.getInstance().treeBuilder().getTreeAtomicNumber());
                    break;
                case 5:
                    Data.getInstance().getMostDistanceNodes(Data.getInstance().treeBuilder().getTreeAtomicNumber());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção não é válida\n");
                    break;
            }
        } while (opcao != 0);
    }

    public static void showMenu(TreeBuilder treeCreate) {
        int opcao;
        do {
            System.out.println();
            out.format("1 - Find By Atomic Number\n");
            out.format("2 - Find By Element\n");
            out.format("3 - Find By Symbol\n");
            out.format("4 - Find By Atomic Mass \n");

            out.format("0/ SAIR\n");
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Insira O numero Atomic:");
                    Data.getInstance().getElementAtomicNumber(treeCreate.getTreeAtomicNumber(), in.nextInt());
                    break;
                case 2:
                    System.out.println("Insira O Nome:");
                    Data.getInstance().getElementByName(treeCreate.getTreeByName(), in.nextLine());
                    break;
                case 3:
                    System.out.println("Insira O numero Simbolo:");

                    Data.getInstance().getElementBySymbol(treeCreate.getTreeBySymbol(), in.nextLine());
                    break;
                case 4:
                    System.out.println("Insira a Massa Atómica");
                    Data.getInstance().getElementAtomicMass(treeCreate.getTreeAtomicMass(), in.nextDouble());
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
