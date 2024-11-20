package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;
import java.util.List;
import static com.codeborne.selenide.Selenide.page;

public class SortTest extends BaseTest {

    @Epic("Сортировка")
    @Feature("Сортировка по имени A-Z")
    @Story("Проверка корректности сортировки по имени A-Z")
    @Description("Тест покрывает кейс 1p001 - проверка сортировки по имени A-Z")
    @Test
    public void testSortNameAZ() {
        Allure.step("Вход в систему", () -> {
            page(LoginPage.class).logIn();
        });
        Allure.step("Получение текущих элементов в инвентаре", () -> {
            InventoryPage inventoryPage = new InventoryPage();
            List<String> beforeSort = inventoryPage.inventoryItems.texts();
            Allure.step("Ожидаемый порядок сортировки A-Z", () -> {
                List<String> expectedSort = inventoryPage.getExpectedSortOrderAZ(beforeSort);
                Allure.step("Проверка сортировки A-Z", () -> {
                    List<String> actualSort = inventoryPage.sortNameAZ();
                    Assert.assertEquals(expectedSort, actualSort, "Sorting A-Z failed");
                });
            });
        });
    }
    @Epic("Сортировка")
    @Feature("Сортировка по имени Z-A")
    @Story("Проверка корректности сортировки по имени Z-A")
    @Description("Тест покрывает кейс 1p002 - проверка сортировки по имени Z-A")
    @Test
    public void testSortNameZA() {
        Allure.step("Вход в систему", () -> {
            page(LoginPage.class).logIn();
        });
        Allure.step("Получение текущих элементов в инвентаре", () -> {
            InventoryPage inventoryPage = new InventoryPage();
            List<String> beforeSort = inventoryPage.inventoryItems.texts();
            Allure.step("Ожидаемый порядок сортировки Z-A", () -> {
                List<String> expectedSort = inventoryPage.getExpectedSortOrderZA(beforeSort);
                Allure.step("Проверка сортировки Z-A", () -> {
                    List<String> actualSort = inventoryPage.sortNameZA();
                    Assert.assertEquals(expectedSort, actualSort, "Sorting Z-A failed");
                });
            });
        });
    }
    @Epic("Сортировка")
    @Feature("Сортировка по цене от низкой к высокой")
    @Story("Проверка корректности сортировки по цене от низкой к высокой")
    @Description("Тест покрывает кейс 1p004 - проверка сортировки по цене от низкой к высокой")
    @Test
    public void testSortNameLowToHigh() {
        Allure.step("Вход в систему", () -> {
            page(LoginPage.class).logIn();
        });
        Allure.step("Получение текущих цен в инвентаре", () -> {
            InventoryPage inventoryPage = new InventoryPage();
            List<String> prices = inventoryPage.inventoryPrice.texts();
            Allure.step("Ожидаемый порядок сортировки по цене от низкой к высокой", () -> {
                List<Double> expectedSort = inventoryPage.getExpectedSortOrderLowToHigh(prices);
                Allure.step("Проверка сортировки по цене от низкой к высокой", () -> {
                    List<Double> actualSort = inventoryPage.sortNameLowToHigh();
                    Assert.assertEquals(expectedSort, actualSort, "Sorting Low-High failed");
                });
            });
        });
    }
    @Epic("Сортировка")
    @Feature("Сортировка по цене от высокой к низкой")
    @Story("Проверка корректности сортировки по цене от высокой к низкой")
    @Description("Тест покрывает кейс 1p003 - проверка сортировки по цене от высокой к низкой")
    @Test
    public void testSortNameHighToLow() {
        Allure.step("Вход в систему", () -> {
            page(LoginPage.class).logIn();
        });
        Allure.step("Получение текущих цен в инвентаре", () -> {
            InventoryPage inventoryPage = new InventoryPage();
            List<String> prices = inventoryPage.inventoryPrice.texts();
            Allure.step("Ожидаемый порядок сортировки по цене от высокой к низкой", () -> {
                List<Double> expectedSort = inventoryPage.getExpectedSortOrderHighToLow(prices);
                Allure.step("Проверка сортировки по цене от высокой к низкой", () -> {
                    List<Double> actualSort = inventoryPage.sortNameHighToLow();
                    Assert.assertEquals(expectedSort, actualSort, "Sorting High-Low failed");
                });
            });
        });
    }
}