import java.util.List;
import java.util.Scanner;

public class Main {
      private static final Scanner scanner = new Scanner(System.in);
      private static final CsvWriteAndReadFile csv = new CsvWriteAndReadFile();
      private static final ProductManagement products = new ProductManagement();

      static {
          Product product1 = new Product("S1", "Xoai", 15000, 12, "ngon");
          Product product2 = new Product("S2", "Tao", 14000, 20, "ngon");
          Product product3 = new Product("S3", "Ca chua", 13000, 11, "ngon");
          Product product4 = new Product("S4", "Man", 12000, 18, "ngon");
          Product product5 = new Product("S5", "Cam", 17000, 17, "ngon");
          products.addNewProduct(product1);
          products.addNewProduct(product2);
          products.addNewProduct(product3);
          products.addNewProduct(product4);
          products.addNewProduct(product5);
      }

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true){
            System.out.println("menu");
            System.out.println("1. display list");
            System.out.println("2. add new product");
            System.out.println("3. edit product");
            System.out.println("4. delete product");
            System.out.println("5. sort");
            System.out.println("6. find");
            System.out.println("7. read file");
            System.out.println("8. write file");
            System.out.println("9. exit");
            System.out.println("Your choice : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayListProduct();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    editProductByCode(products.getProducts());
                    break;
                case 4:
                    System.out.println("Enter code product want delete");
                    String codeProduct = scanner.nextLine();
                    products.deleteProductByCode(codeProduct);
                case 7:
                    csv.readProduct();
                    break;
                case 8:
                    csv.writeProduct(products.getProducts());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("choice again");
            }
        }
    }

    private static void addNewProduct() {
        System.out.println("Enter code product: ");
        String codeProduct = scanner.nextLine();
        System.out.println("Enter name product: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Enter price product: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        Product product = new Product(codeProduct, nameProduct, price, quantity, description);
        products.addNewProduct(product);
        System.out.println("Add done");
    }


    private static void editProductByCode(List<Product> products){
        System.out.println("Enter code product: ");
        String codeProduct = scanner.nextLine().trim();
        int index = -1;
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getCodeProduct().equals(codeProduct)){
                index = i;
                break;
            }
        }
        if (index != -1){
            System.out.println("Information before editing: ");
            System.out.println(products.get(index));

            System.out.println("Select the information to edit: ");
            System.out.println("1. Code Product");
            System.out.println("2. Name product");
            System.out.println("3. price");
            System.out.println("4. quantity");
            System.out.println("5. description");

            System.out.print("Enter your selection: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter new Code Product: ");
                    String codeProductNew = scanner.nextLine();
                    products.get(index).setCodeProduct(codeProductNew);
                    break;
                case 2:
                    System.out.print("Enter new Name product: ");
                    String nameProduct = scanner.nextLine();
                    products.get(index).setNameProduct(nameProduct);
                    break;
                case 3:
                    System.out.print("Enter new price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    products.get(index).setPrice(price);
                    break;
                case 4:
                    System.out.println("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    products.get(index).setQuantity(quantity);
                    break;
                case 5:
                    System.out.println("Enter new description: ");
                    String description = scanner.nextLine();
                    products.get(index).setDescription(description);
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }

            System.out.println("Information after editing:");
            System.out.println(products.get(index));
        } else {
            System.out.println("No student found with ID: " + codeProduct);
        }
    }
private static void displayListProduct(){
        List<Product> products1 = products.getProducts();
        for (Product product: products1){
            System.out.println(product);
        }
}
}