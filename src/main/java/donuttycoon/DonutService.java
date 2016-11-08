package donuttycoon;

import donuttycoon.Donut;
import java.util.*;


public class DonutService {

    private Map<String, Donut> donuts = new HashMap<String, Donut>();

    public List<Donut> getAllDonuts() {
        return new ArrayList<Donut>(donuts.values());
    }

    public Donut getDonut(String id) {
        return donuts.get(id);
    }

    public Donut createDonut(String name, String topping, Integer price) {
        failIfInvalid(name, topping, price);
        Donut donut = new Donut(name, topping, price);
        donuts.put(donut.getId(), donut);
        return donut;
    }

    public Donut updateDonut(String id, String name, String topping, Integer price) {
        // System.out.println(donuts.get(id));
        System.out.println("updateDonut");
        Donut donut = donuts.get(id);
        if (donut == null) {
            throw new IllegalArgumentException("No donut with id '" + id + "' found");
        }
        failIfInvalid(name, topping, price);
        donut.setName(name);
        donut.setTopping(topping);
        donut.setPrice(price);
        return donut;
    }

    private void failIfInvalid(String name, String topping, Integer price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Parameter 'name' cannot be empty");
        }
        if (topping == null || topping.isEmpty()) {
            throw new IllegalArgumentException("Parameter 'topping' cannot be empty");
        }
        if (price == null) {
          throw new IllegalArgumentException("Parameter 'price' cannot be empty");
        }
    }
}
