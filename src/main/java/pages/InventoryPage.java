package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {

    private final SelenideElement sortContainer = $("[class='product_sort_container']");
    private final SelenideElement sortByA_Z = $("[value='az']");
    private final SelenideElement sortByZ_A = $("[value='za']");
    private final SelenideElement sortLowToHigh = $("[value='lohi']");
    private final SelenideElement sortHighToLow = $("[value='hilo']");
    private final SelenideElement addToCartBtn = $("#add-to-cart-sauce-labs-bike-light");
    public final ElementsCollection inventoryItems = $$("[class='inventory_item_name ']");
    public final ElementsCollection inventoryPrice = $$("[class='inventory_item_price']");

    public List<String> sortNameAZ() {
        sortContainer.click();
        sortByA_Z.click();
        return inventoryItems.texts();
    }
    public List<String> getExpectedSortOrderAZ(List<String> originalList) {
        return originalList.stream()
                .sorted()
                .toList();
    }

    public List<String> sortNameZA() {
        sortContainer.click();
        sortByZ_A.click();
        return inventoryItems.texts();
    }
    public List<String> getExpectedSortOrderZA(List<String> originalList) {
        return originalList.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public List<Double> sortNameLowToHigh() {
        sortContainer.click();
        sortLowToHigh.click();
        List<String> sortedPrices = inventoryPrice.texts();
        return sortedPrices.stream()
                .map(s -> Double.parseDouble(s.replace("$", "")))
                .toList();
    }
    public List<Double> getExpectedSortOrderLowToHigh(List<String> prices) {
        return prices.stream()
                .map(s -> Double.parseDouble(s.replace("$", "")))
                .sorted()
                .toList();
    }

    public List<Double> sortNameHighToLow() {
        sortContainer.click();
        sortHighToLow.click();
        List<String> sortedPrices = inventoryPrice.texts();
        return sortedPrices.stream()
                .map(s -> Double.parseDouble(s.replace("$", "")))
                .toList();
    }
    public List<Double> getExpectedSortOrderHighToLow(List<String> prices) {
        return prices.stream()
                .map(s -> Double.parseDouble(s.replace("$", "")))
                .sorted(Comparator.reverseOrder())
                .toList();
    }
}
