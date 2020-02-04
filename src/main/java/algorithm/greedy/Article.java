package algorithm.greedy;

public class Article {
    private int weight;
    private double price;
    private double priceDensity;

    public Article(int weight, double price) {
        this.weight = weight;
        this.price = price;
        this.priceDensity = price / weight;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceDensity() {
        return priceDensity;
    }

    @Override
    public String toString() {
        return "Article{" +
                "weight=" + weight +
                ", price=" + price +
                ", priceDensity=" + priceDensity +
                '}';
    }
}
