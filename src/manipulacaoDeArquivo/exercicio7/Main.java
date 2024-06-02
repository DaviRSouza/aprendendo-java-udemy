package manipulacaoDeArquivo.exercicio7;

import manipulacaoDeArquivo.exercicio7.entities.Products;
import manipulacaoDeArquivo.exercicio7.util.FileManager;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String INPUT_PATH = "c:\\manipulacao\\input.csv";
    private static final String OUTPUT_DIR = "c:\\manipulacao\\out";
    private static final String OUTPUT_FILE = "output.csv";

    public static void main(String[] args) {
        List<Products> productsList;

        try {
            productsList = FileManager.readProductsFromFile(INPUT_PATH);
            FileManager.createOutputDirectory(OUTPUT_DIR);
            FileManager.writeProductsToFile(productsList, OUTPUT_DIR, OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}