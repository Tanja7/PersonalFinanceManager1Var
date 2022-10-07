public class MaxCategory {

    private String category;

    private int maxSum;

    public MaxCategory() {
    }

    public MaxCategory(String category, int maxSum) {
        this.category = category;
        this.maxSum = maxSum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(int maxSum) {
        this.maxSum = maxSum;
    }
}
