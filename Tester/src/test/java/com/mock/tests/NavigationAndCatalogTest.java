package com.mock.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

class NavigationAndCatalogTest extends BaseUiTest {

    private static final By PRODUCT_DETAIL_LINKS = By.cssSelector("a[href*='ChiTietSanPham.aspx?ID=']");
    private static final By PRODUCT_NAME = By.id("ContentPlaceHolder1_Datalist1_lblTenSP_0");
    private static final By PRODUCT_PRICE = By.id("ContentPlaceHolder1_Datalist1_lblGiaSP_0");
    private static final By QTY_INPUT = By.id("ContentPlaceHolder1_Datalist1_txtSoLuong_0");

    private void assertNoServerErrorPage(String reason) {
        String source = driver.getPageSource().toLowerCase();
        Assertions.assertFalse(source.contains("runtime error"), reason + " - runtime error page");
        Assertions.assertFalse(source.contains("server error in"), reason + " - server error page");
        Assertions.assertFalse(source.contains("exception details"), reason + " - exception details exposed");
    }

    @Test
    void homePageLoadsAndShowsMainMenu() {
        open("Default.aspx");
        Assertions.assertTrue(driver.getTitle().contains("Trang ch"));
        Assertions.assertTrue(displayed(By.id("HyperLink1")));
        Assertions.assertTrue(displayed(By.id("HyperLink2")));
        Assertions.assertTrue(displayed(By.id("HyperLink3")));
        Assertions.assertTrue(displayed(By.id("HyperLink4")));
        assertNoServerErrorPage("Home page");
    }

    @Test
    void topMenuNavigatesToAllUserPages() {
        open("Default.aspx");

        clickable(By.id("HyperLink2")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Kinhmat.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Kinhmat.aspx"));

        clickable(By.id("HyperLink3")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Lienhe.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Lienhe.aspx"));

        clickable(By.id("HyperLink4")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Giohang.aspx"));

        assertNoServerErrorPage("Top menu navigation");
    }

    @Test
    void categoryLinkNavigatesToFilteredCatalog() {
        open("Default.aspx");
        clickable(By.cssSelector("a[href='Kinhmat.aspx?ID=1']")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Kinhmat.aspx?ID=1"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Kinhmat.aspx?ID=1"));
        assertNoServerErrorPage("Category ID=1");
    }

    @Test
    void catalogHasProductsAndCanOpenDetail() {
        open("Kinhmat.aspx");
        List<WebElement> detailLinks = driver.findElements(PRODUCT_DETAIL_LINKS);
        Assertions.assertFalse(detailLinks.isEmpty());

        detailLinks.get(0).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("ChiTietSanPham.aspx?ID="));
        Assertions.assertFalse(text(PRODUCT_NAME).isBlank());
        Assertions.assertFalse(text(PRODUCT_PRICE).isBlank());
        assertNoServerErrorPage("Open detail from catalog");
    }

    @Test
    void loginAndRegisterMenuLinksNavigateToCorrectPages() {
        open("Default.aspx");

        clickable(By.id("LinkDN")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Dangnhap.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Dangnhap.aspx"));

        open("Default.aspx");
        clickable(By.id("LinkDK")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Dangky.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Dangky.aspx"));

        assertNoServerErrorPage("Login/register menu links");
    }

    @Test
    void allLeftCategoriesAreReachable() {
        open("Default.aspx");
        List<String> categoryUrls = driver.findElements(By.cssSelector("a[href*='Kinhmat.aspx?ID=']")).stream()
                .map(element -> element.getAttribute("href"))
                .distinct()
                .collect(Collectors.toList());

        Assertions.assertFalse(categoryUrls.isEmpty());
        for (String categoryUrl : categoryUrls) {
            driver.get(categoryUrl);
            wait.until(webDriver -> webDriver.getCurrentUrl().contains("Kinhmat.aspx?ID="));
            Assertions.assertTrue(driver.getCurrentUrl().contains("Kinhmat.aspx?ID="));
            assertNoServerErrorPage("Left category URL: " + categoryUrl);
        }
    }

    @Test
    void detailPageHasDefaultQuantityOne() {
        open("ChiTietSanPham.aspx?ID=17");
        Assertions.assertEquals("1", visible(QTY_INPUT).getAttribute("value"));
        assertNoServerErrorPage("Detail default quantity");
    }

    @Test
    void catalogPageShouldHaveAtLeastOneProductDetailLink() {
        open("Kinhmat.aspx");
        List<WebElement> links = driver.findElements(PRODUCT_DETAIL_LINKS);
        Assertions.assertFalse(links.isEmpty());
        assertNoServerErrorPage("Catalog page");
    }

    @Test
    void productDetailShouldShowCoreFields() {
        open("ChiTietSanPham.aspx?ID=17");
        Assertions.assertFalse(text(PRODUCT_NAME).isBlank());
        Assertions.assertFalse(text(PRODUCT_PRICE).isBlank());
        Assertions.assertEquals("1", visible(QTY_INPUT).getAttribute("value"));
        assertNoServerErrorPage("Product detail");
    }

    @ParameterizedTest(name = "Category id ''{0}'' should be handled gracefully")
    @ValueSource(strings = {"1", "7", "9999", "abc", "-1"})
    void categoryIdVariationsShouldBeHandledGracefully(String categoryId) {
        open("Kinhmat.aspx?ID=" + categoryId);
        Assertions.assertTrue(driver.getCurrentUrl().toLowerCase().contains("kinhmat.aspx"));
        assertNoServerErrorPage("Category ID=" + categoryId);
    }

    @ParameterizedTest(name = "Product id ''{0}'' should be handled gracefully")
    @ValueSource(strings = {"1", "17", "99999", "abc", "-1"})
    void productIdVariationsShouldBeHandledGracefully(String productId) {
        open("ChiTietSanPham.aspx?ID=" + productId);
        Assertions.assertTrue(driver.getCurrentUrl().toLowerCase().contains("chitietsanpham.aspx"));
        assertNoServerErrorPage("Product ID=" + productId);
    }
}
