import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class AssignmentNo3 {

    public static void main(String[] args) {
        HashMap<String, Double> productPrices = new HashMap<>();
        productPrices.put("bananas", 0.89);
        productPrices.put("tomatoes", 0.59);
        productPrices.put("carrots", 0.34);
        productPrices.put("apples", 0.59);
        productPrices.put("cucumber", 0.64);
        productPrices.put("lemons", 1.19);
        productPrices.put("oranges", 1.59);
        productPrices.put("grapes", 2.19);

        System.out.println("Amount of products under 1 EUR: " + underEuro(productPrices));
        findLowestPrice(productPrices);
        largestPrice(productPrices);

        HashMap<String, Double> productPrices1 = new HashMap<>();
        productPrices1.put("milk", 0.89);
        productPrices1.put("butter", 1.19);
        productPrices1.put("yogurt", 0.99);
        productPrices1.put("dessert", 2.99);

        productPrices.putAll(productPrices1);
        System.out.println("Amount of products in the merged HashMap: " + productPrices.size());

        sortByValues(productPrices);
    }

    public static int underEuro(HashMap<String, Double> productPrices) {
        int counter = 0;
        for (double p : productPrices.values()) {
            if (p < 1.00) {
                counter++;
            }
        }
        return counter;
    }

    public static void findLowestPrice(HashMap<String, Double> productPrices) {
        double minValue = Collections.min(productPrices.values());
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            if (entry.getValue() == minValue) {
                System.out.println("Product with lowest price: " + entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public static void largestPrice(HashMap<String, Double> productPrices) {
        double maxValue = Collections.max(productPrices.values());
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println("Product with largest price: " + entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public static void sortByValues(HashMap<String, Double> productPrices) {
        Map<String, Double> result = new LinkedHashMap();
        productPrices.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        System.out.println("All products sorted by price:");
        System.out.println(result);
    }
}
