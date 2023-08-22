package program;

import entidades.Company;
import entidades.Individual;
import entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> list = new ArrayList<>();

        System.out.print("Digite o número de contribuintes:");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            System.out.println("Dados do contribuinte nº" + i + ":");
            System.out.print("Individual ou company: (i/c): ");
            char ic = sc.next().charAt(0);
            if (ic == 'i') {
                System.out.print("Nome:");
                sc.nextLine();
                String nome = sc.nextLine();
                System.out.print("Rendimento anual: ");
                double rendaAnual = sc.nextDouble();
                System.out.print("Gastos com saude: ");
                double gastosSaude = sc.nextDouble();
                list.add(new Individual(nome, rendaAnual, gastosSaude));

            } else if (ic == 'c') {
                System.out.print("Nome: ");
                sc.nextLine();
                String nome = sc.nextLine();
                System.out.print("Rendimento anual: ");
                double rendaAnual = sc.nextDouble();
                System.out.print("Numero de funcionarios:");
                int numeroFuncionarios = sc.nextInt();
                list.add(new Company(nome, rendaAnual, numeroFuncionarios));
            }
        }
        System.out.println();
        System.out.println("IMPOSTOS PAGOS:");
        for (Pessoa p : list) {
            System.out.println(p.getNome() + ": $" + String.format("%.2f", p.tax()));
        }
        double soma = 0;
        for (Pessoa p : list) {
            soma += p.tax();
        }
        System.out.println();
        System.out.println("TOTAL DE TAXAS: " + soma);
    }
}
