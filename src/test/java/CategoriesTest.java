import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование: Categories")
public class CategoriesTest {
    private Categories categories = new Categories();

    @BeforeEach
    void setUp() {
        categories.readTSV();
    }

    @Test
    @DisplayName("Тестирование метода определения категории у продукта")
    void getCategoryByName() {
        Assertions.assertEquals("еда", categories.getCategoryByName("булка").getCategory());
        Assertions.assertEquals("одежда", categories.getCategoryByName("тапки").getCategory());
    }

    @Test
    @DisplayName("Тестирование метода добавления суммы в категорию")
    void addSumByCategory() {
        categories.addSumByCategory("еда", 50);
        categories.addSumByCategory("еда", 550);
        Integer sumCat = categories.getSumByCategory("еда");
        Assertions.assertEquals(600, sumCat);
    }

    @Test
    @DisplayName("Тестирование метода поиска максимальной категории")
    void getMaxCategory() {
        categories.addSumByCategory("еда", 50);
        categories.addSumByCategory("еда", 350);
        categories.addSumByCategory("одежда", 150);
        Category maxCategory = categories.getMaxCategory();
        Assertions.assertEquals("еда", maxCategory.getCategory());
        Assertions.assertEquals(400, maxCategory.getSum());
    }
}
