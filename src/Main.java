import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, PricingRule> rules = new HashMap<>();
        rules.put("A", new PricingRule(50, 3, 130));
        rules.put("B", new PricingRule(30, 2, 45));
        rules.put("C", new PricingRule(20, 0, 0));
        rules.put("D", new PricingRule(15, 0, 0));

        Checkout co = new Checkout(rules);
        co.scan("A");
        co.scan("B");
        co.scan("A");
        co.scan("B");
        co.scan("A");
        System.out.println("Total: $" + co.total() / 100.0);
    }
}