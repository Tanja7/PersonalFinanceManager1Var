import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Categories {
    // Ключ - название продукта, значение - категория
    private final Map<String, Category> categoryByName = new HashMap<>();

    // Ключ - название категории, значение - сумма категории
    private final Map<String, Integer> sumByCategory = new HashMap<>();

    public Categories() {

    }

    public Category getCategoryByName(String productName) {
        if (categoryByName.containsKey(productName))
            return categoryByName.get(productName);
        else
            return new Category();
    }

    public void addSumByCategory(String category, int sum) {
        if (sumByCategory.containsKey(category)) {
            Integer sum1 = sumByCategory.get(category) + sum;
            sumByCategory.replace(category, sum1);
        } else
            sumByCategory.put(category, sum);
    }

    public Integer getSumByCategory(String category) {
        if (sumByCategory.containsKey(category)) {
            return sumByCategory.get(category);
        } else {
            return -1;
        }
    }

    public Category getMaxCategory() {
        Integer maxSum = null;
        Category maxCategory = null;
        Iterator<Map.Entry<String, Integer>> iterator = sumByCategory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (maxSum == null) {
                maxSum = entry.getValue();
                maxCategory = new Category("", entry.getKey(), entry.getValue());
            } else if (entry.getValue() > maxSum) {
                maxSum = entry.getValue();
                maxCategory = new Category("", entry.getKey(), entry.getValue());
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