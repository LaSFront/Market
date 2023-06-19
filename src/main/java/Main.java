public class Main {
    public static void main(String[] args) {
        ShopRepository repo = new ShopRepository();

        repo.add(new Product(11, "bread", 100));
        repo.add(new Product(12, "milk", 75));
        repo.add(new Product(13, "butter", 150));
        repo.add(new Product(14, "chocolate", 175));

        repo.findAll();

        //repo.removeById(115);

        //repo.add(new Product(14, "coffee", 180));
    }
}

