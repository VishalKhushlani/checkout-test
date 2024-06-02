import java.util.HashMap;
import java.util.Map;

/**
 * Checkout system for a supermarket that handles pricing and cart management.
 * It can apply regular and special pricing rules to items scanned.
 */
public class Checkout {
    private final Map<String, PricingRule> pricingRules;
    private final Map<String, Integer> cart;

    /**
     * Constructs a new Checkout instance with the specified pricing rules.
     *
     * @param pricingRules the pricing rules to use, mapping item SKUs to their pricing rules
     */
    public Checkout(Map<String, PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
        this.cart = new HashMap<>();
    }

    /**
     * Scans an item and adds it to the cart. If the item is already in the cart,
     * increments the quantity.
     *
     * @param item the SKU of the item to scan
     */
    public void scan(String item) {
        this.cart.merge(item, 1, Integer::sum);
    }

    /**
     * Calculates the total cost of all items in the cart based on the pricing rules.
     * Applies special pricing if the quantity of an item meets or exceeds the special
     * quantity threshold defined in its pricing rule.
     *
     * @return the total cost of the items in the cart
     */
    public int total() {
        final int[] totalCost = {0};
        cart.forEach((item, quantity) -> {
            PricingRule rule = pricingRules.get(item);
            if (rule != null) {
                int unitPrice = rule.getUnitPrice();
                if (rule.getSpecialQty() > 0 && quantity >= rule.getSpecialQty()) {
                    int bundles = quantity / rule.getSpecialQty();
                    int remainder = quantity % rule.getSpecialQty();
                    totalCost[0] += bundles * rule.getSpecialPrice() + remainder * unitPrice;
                } else {
                    totalCost[0] += quantity * unitPrice;
                }
            }
        });
        return totalCost[0];
    }
}