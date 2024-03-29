public class Product implements Comparable<Product> {
    private String codeProduct;
    private String nameProduct;
    private double price;
    private int quantity;
    private String description;

    public Product() {
    }
    public Product(String codeProduct, String nameProduct, double price, int quantity, String description) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String CovertToLine(){
        return this.codeProduct + "," + this.nameProduct + "," + this.price + "," + this.quantity+ "," + this.description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
