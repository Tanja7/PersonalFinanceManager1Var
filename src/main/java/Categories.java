import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Categories {
    // Ключ - название продукта, значение - категория
    private final Map<String, Category> categoryByName = new HashMap<>();

    // Ключ - название категории, значение - объект категория
    private final Map<String, Category> categoryByCategoryName = new HashMap<>();

    public Categories() {

    }

    public Category getCategoryByName(String productName) {
        if (categoryByName.containsKey(productName))
            return categoryByName.get(productName);
        else
            return new Category();
    }

    public void addSumByCategory(Category category, int sum) {
        if (categoryByCategoryName.containsKey(category.getCategory())) {
            Category sum1 = categoryByCategoryName.get(category.getCategory());
            sum1.setSum(sum1.getSum() + sum);
        } else
            categoryByCategoryName.put(category.getCategory(),
                    new Category(category.getTitleBase(), category.getCategory(), sum));
    }

    public Category getMaxCategory() {
        Integer maxSum = null;
        Category maxCategory = null;
        Iterator<Map.Entry<String, Category>> iterator = categoryByCategoryName.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Category> entry = iterator.next();
            if (maxSum == null) {
                maxSum = entry.getValue().getSum();
                maxCategory = entry.getValue();
            } else if (entry.getValue().getSum() > maxSum) {
                maxSum = entry.getValue().getSum();
                maxCategory = entry.getValue();
            }
        }
        return maxCategory;
    }

    public void readTSV() {
        try {
            BufferedReader TSVFile =
                    new BufferedReader(new FileReader("categories.tsv"));
            String stroka = TSVFile.readLine();
            while (stroka != null) {
                String[] titAndCat = stroka.split("\t");
                categoryByName.put(titAndCat[0], new Category(titAndCat[0], titAndCat[1], 0));
                stroka = TSVFile.readLine();
            }
            TSVFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}