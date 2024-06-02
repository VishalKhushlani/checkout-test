/**
 * Represents the pricing rules for an item in a supermarket.
 * This class holds the regular unit price of the item, the quantity needed to qualify
 * for a special price, and the special price itself.
 */
public class PricingRule {
    private int unitPrice;
    private int specialQty;
    private int specialPrice;

    public PricingRule(int unitPrice, int specialQty, int specialPrice) {
        this.unitPrice = unitPrice;
        this.specialQty = specialQty;
        this.specialPrice = specialPrice;
    }

    /**
     * Returns the unit price of the item.
     *
     * @return the regular price per single unit of the item
     */
    public int getUnitPrice() {
        return unitPrice;
    }

    /**
     * Returns the quantity required to qualify for the special price.
     *
     * @return the minimum quantity needed for the special pricing to apply
     */
    public int getSpecialQty() {
        return specialQty;
    }

    /**
     * Returns the special price applicable when the required quantity is met.
     *
     * @return the discounted price for the required quantity of items
     */
    public int getSpecialPrice() {
        return specialPrice;
    }
}