package donuttycoon;

import java.util.concurrent.atomic.AtomicInteger;

public class Donut {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String id;
    private String name;
    private String topping;
    private Integer price;

    public Donut(String name, String topping, Integer price) {
        this.id = Integer.toString(count.incrementAndGet());
        this.name = name;
        this.topping = topping;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopping() {
        return this.topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
