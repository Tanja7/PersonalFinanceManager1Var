import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Analysis {
    private String title;
    private String date;
    private int sum;

    Categories categories = new Categories();

    public Analysis() {
        categories.readTSV();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return title + " - " + date + " - " + sum;
    }

    public static Analysis fromJson(String json) {
        //   код для преобразования JSON в Java
        ObjectMapper mapper = new ObjectMapper();
        Analysis analysis = null;
        try {
            analysis = mapper.readValue(json, Analysis.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return analysis;
    }

    public String readMessage(String message) {
        Analysis analysis = fromJson(message);

        // приведение названия к категории
        var category = categories.getCategoryByName(analysis.getTitle());

        // суммировать покупки по категориям и найти максимальную
        categories.addSumByCategory(category.getCategory(), analysis.getSum());
       return toJson();
    }
    public String toJson() {
        var maxCategory = categories.getMaxCategory();
        MaxCategory maxCategory1 = new MaxCategory(maxCategory.getCategory(), maxCategory.getSum());
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult=null;
        try {
            // Java объект в JSON строку
            jsonResult = "{\"maxCategory\": " + mapper.writeValueAsString(maxCategory1) +
                    " }";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonResult;
    }

}




