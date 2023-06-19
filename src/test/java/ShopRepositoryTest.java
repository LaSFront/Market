import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldCheckRemoveElement() {
        ShopRepository repo = new ShopRepository();

        repo.add(new Product(11, "bread", 100));
        repo.add(new Product(12, "milk", 75));
        repo.add(new Product(13, "butter", 150));
        repo.add(new Product(14, "chocolate", 175));

        repo.removeById(12);

        Product[] expected = {new Product(11, "bread", 100), new Product(13, "butter", 150), new Product(14, "chocolate", 175)};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfIdNotFoundBeforeRemove() {
        ShopRepository repo = new ShopRepository();

        repo.add(new Product(11, "bread", 100));
        repo.add(new Product(12, "milk", 75));
        repo.add(new Product(13, "butter", 150));
        repo.add(new Product(14, "chocolate", 175));

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(115);
        });
    }

    @Test
    public void shouldCheckThatElementsWereAddedIfNotFound() {
        ShopRepository repo = new ShopRepository();

        repo.add(new Product(11, "bread", 100));
        repo.add(new Product(12, "milk", 75));
        repo.add(new Product(13, "butter", 150));
        repo.add(new Product(14, "chocolate", 175));

        Product[] expected = {new Product(11, "bread", 100), new Product(12, "milk", 75), new Product(13, "butter", 150), new Product(14, "chocolate", 175)};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfIdFoundBeforeAdd() {
        ShopRepository repo = new ShopRepository();

        repo.add(new Product(11, "bread", 100));
        repo.add(new Product(12, "milk", 75));
        repo.add(new Product(13, "butter", 150));
        repo.add(new Product(14, "chocolate", 175));

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.add(new Product(14, "coffee", 180));
        });
    }
}
