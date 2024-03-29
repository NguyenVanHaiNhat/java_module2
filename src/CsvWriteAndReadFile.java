import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvWriteAndReadFile {
    private static final String FILE_PRODUCT ="E:\\Bootcamp Java Fullstack\\C1023H1-JV101-NguyenVanHaiNhat\\Module_2\\test\\Thicuici\\src\\data\\products.csv";
    public void writeProduct(List<Product> products){
        List<String> strings = new ArrayList<>();
        for (Product product: products){
            strings.add(product.CovertToLine());
        }
        writeToFile(FILE_PRODUCT, strings);
    }
    public List<Product> readProduct(){
        List<Product> products = new ArrayList<>();
        List<String> strings = readFromFile(FILE_PRODUCT);

        String temp[];
        for (String s: strings){
            temp = s.split(",");
            String codeProduct = temp[0];
            String nameProduct = temp[1];
            double price = Double.parseDouble(temp[2]);
            int quantity = Integer.parseInt(temp[3]);
            String description = temp[4];

            Product product = new Product(codeProduct, nameProduct, price, quantity, description);
            products.add(product);
        }
        return products;
    }
    private void writeToFile(String pathFile, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<String> readFromFile(String pathFile) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
