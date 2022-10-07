public class Category {
    private String titleBase;
    private String category = "другое";
    private Integer sum;

    public Category(String titleBase, String category, Integer sum) {
        this.titleBase = titleBase;
        this.category = category;
        this.sum = sum;
    }

    public Category() {

    }

    public String getTitleBase() {
        return titleBase;
    }

    public void setTitleBase(String titleBase) {
        this.titleBase = titleBase;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return titleBase + " - " + category;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

}
