package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;
import java.util.List;
import static com.codeborne.selenide.Selenide.page;

public class SortTest extends BaseTest{

    /** Тест testSortNameAZ покрывает кейс 1p001.
     *  Assert в этом тесте проверяет корректность сортировки по имени.
     */

    @Test
    public void testSortNameAZ() {
        page(LoginPage.class).logIn();
        InventoryPage inventoryPage = new InventoryPage();
        List<String> beforeSort = inventoryPage
                .inventoryItems.texts();
        List<String> actualSort = inventoryPage
                .sortNameAZ();
        List<String> expectedSort = inventoryPage
                .getExpectedSortOrderAZ(beforeSort);
        Assert.assertEquals(expectedSort, actualSort, "Sorting A-Z failed");
    }

    /** Тест testSortNameZA покрывает кейс 1p002.
     *  Assert в этом тесте проверяет корректность сортировки по имени.
     */
    @Test
    public void testSortNameZA() {
        page(LoginPage.class).logIn();
        InventoryPage inventoryPage = new InventoryPage();
        List<String> beforeSort = inventoryPage
                .inventoryItems
                .texts();
        List<String> actualSort = inventoryPage
                .sortNameZA();
        List<String> expectedSort = inventoryPage
                .getExpectedSortOrderZA(beforeSort);
        Assert.assertEquals(expectedSort, actualSort, "Sorting Z-A failed");
    }

    /** Тест testSortNameLowToHigh покрывает кейс 1p004.
     *  Assert в этом тесте проверяет корректность сортировки по цене.
     */
    @Test
    public void testSortNameLowToHigh() {
        page(LoginPage.class).logIn();
        InventoryPage inventoryPage = new InventoryPage();
        List<String> prices = inventoryPage
                .inventoryPrice
                .texts();
        List<Double> actualSort = inventoryPage
                .sortNameLowToHigh();
        List<Double> expectedSort = inventoryPage
                .getExpectedSortOrderLowToHigh(prices);
        Assert.assertEquals(expectedSort, actualSort, "Sorting Low-High failed");
    }

    /** Тест testSortNameLowToHigh покрывает кейс 1p003.
     *  Assert в этом тесте проверяет корректность сортировки по цене.
     */
    @Test
    public void testSortNameHighToLow() {
        page(LoginPage.class).logIn();
        InventoryPage inventoryPage = new InventoryPage();
        List<String> prices = inventoryPage
                .inventoryPrice
                .texts();
        List<Double> actualSort = inventoryPage
                .sortNameHighToLow();
        List<Double> expectedSort = inventoryPage
                .getExpectedSortOrderHighToLow(prices);
        Assert.assertEquals(expectedSort, actualSort, "Sorting High-Low failed");
    }
}
