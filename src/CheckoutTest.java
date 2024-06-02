import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the Checkout system's ability to calculate totals correctly under various scenarios.
 * This includes handling empty carts, single items, multiple items with and without discounts,
 * and more complex scenarios involving incremental scanning and special pricing rules.
 */
public class CheckoutTest {
    private Map<String, PricingRule> rules;

    /**
     * Sets up the pricing rules for each test. This method is executed before each test method
     * to ensure that the testing environment is correctly initialized.
     */
    @BeforeEach
    public void setUp() {
        rules = new HashMap<>();
        rules.put("A", new PricingRule(50, 3, 130));
        rules.put("B", new PricingRule(30, 2, 45));
        rules.put("C", new PricingRule(20, 0, 0));
        rules.put("D", new PricingRule(15, 0, 0));
    }

    /**
     * Tests the total cost of an empty shopping cart to confirm it calculates to zero.
     */
    @Test
    public void testEmptyCart() {
        Checkout co = new Checkout(rules);
        assertEquals(0, co.total(), "Total should be 0 for an empty cart.");
    }

    /**
     * Tests the total cost for a single scanned item without any special pricing applied.
     */
    @Test
    public void testSingleItem() {
        Checkout co = new Checkout(rules);
        co.scan("A");
        assertEquals(50, co.total(), "Total should be 50 for one 'A'.");
    }

    /**
     * Tests the total cost for multiple items that do not qualify for any discount.
     */
    @Test
    public void testMultipleItemsNoDiscount() {
        Checkout co = new Checkout(rules);
        co.scan("A");
        co.scan("B");
        assertEquals(80, co.total(), "Total should be 80 for one 'A' and one 'B'.");
    }

    /**
     * Tests the application of special pricing when the required quantity for a discount is met.
     */
    @Test
    public void testSpecialPricing() {
        Checkout co = new Checkout(rules);
        co.scan("A");
        co.scan("A");
        co.scan("A");
        assertEquals(130, co.total(), "Total should be 130 for three 'A's (special pricing).");
    }

    /**
     * Tests incremental scanning and total calculation to ensure totals update correctly
     * as items are added one at a time.
     */
    @Test
    public void testIncrementalScanning() {
        Checkout co = new Checkout(rules);
        co.scan("A");
        assertEquals(50, co.total());
        co.scan("B");
        assertEquals(80, co.total());
        co.scan("A");
        assertEquals(130, co.total());
        co.scan("A");
        assertEquals(160, co.total());
        co.scan("B");
        assertEquals(175, co.total());
    }

    /**
     * Tests a more complex cart configuration with multiple items, applying both regular and special pricing.
     */
    @Test
    public void testComplexCart() {
        Checkout co = new Checkout(rules);
        co.scan("A");
        co.scan("A");
        co.scan("B");
        co.scan("A"); // Applies special pricing for 3 'A's
        co.scan("B"); // Applies special pricing for 2 'B's
        co.scan("D");
        assertEquals(190, co.total(), "Complex cart total calculation error.");
    }
}