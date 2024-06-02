package manipulacaoDeArquivo.exercicio7.util;

import manipulacaoDeArquivo.exercicio7.entities.Products;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Products> readProductsFromFile(String path) throws IOException {
        List<Products> productsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] productData = line.split(",");
                if (productData.length == 3) {
                    String productName = productData[0];
                    double productPrice = Double.parseDouble(productData[1]);
                    int productQuantity = Integer.parseInt(productData[2]);
                    Products product = new Products(productName, productPrice, productQuantity);
                    productsList.add(product);
                } else {
                    System.out.println("Invalid product data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException("Input file not found: " + path, e);
        } catch (IOException e) {
            throw new IOException("Error reading from file: " + path, e);
        }
        return productsList;
    }

    public static void createOutputDirectory(String outputDir) throws IOException {
        Path outputPath = Paths.get(outputDir);
        if (!Files.exists(outputPath)) {
            try {
                Files.createDirectories(outputPath);
            } catch (IOException e) {
                throw new IOException("Failed to create output directory: " + outputDir, e);
            }
        }
    }

    public static void writeProductsToFile(List<Products> productsList, String outputDir, String outputFileName) throws IOException {
        Path outputFilePath = Paths.get(outputDir, outputFileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath.toFile()))) {
            for (Products product : productsList) {
                bw.write(product.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error writing to file: " + outputFilePath, e);
        }
    }
}
