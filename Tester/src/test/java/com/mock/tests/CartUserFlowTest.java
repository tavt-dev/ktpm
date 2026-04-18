package com.mock.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

class CartUserFlowTest extends BaseUiTest {

    private static final By CART_EMPTY_LABEL = By.id("ContentPlaceHolder1_gvGioHang_Label1");
    private static final By CART_TOTAL = By.id("ContentPlaceHolder1_lblTongTien");
    private static final By CART_MESSAGE = By.id("ContentPlaceHolder1_lblThongBao");
    private static final By CART_QTY_0 = By.id("ContentPlaceHolder1_gvGioHang_txtSoLuong_0");
    private static final By CART_UPDATE_0 = By.xpath("//input[contains(@onclick,\"gvGioHang\") and contains(@onclick,\"'$0'\")]");
    private static final By CART_CLEAR = By.id("ContentPlaceHolder1_btnXoaGioHang");
    private static final By CART_CHECKOUT = By.id("ContentPlaceHolder1_btnThanhToan");
    private static final By CART_CHECKOUT_MESSAGE = By.id("ContentPlaceHolder1_lblThongBao2");
    private static final By DETAIL_ERROR = By.id("ContentPlaceHolder1_Datalist1_lblThongBao_0");

    private void assertNoServerError(String reason) {
        String source = driver.getPageSource().toLowerCase();
        Assertions.assertFalse(source.contains("runtime error"), reason + " - runtime error page");
        Assertions.assertFalse(source.contains("server error in"), reason + " - server error page");
        Assertions.assertFalse(source.contains("exception details"), reason + " - exception details exposed");
    }

    private boolean hasText(By by) {
        try {
            return !driver.findElement(by).getText().trim().isBlank();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Test
    void cartInitiallyEmpty() {
        open("Giohang.aspx");
        Assertions.assertTrue(text(CART_EMPTY_LABEL).contains("Kh"));
        assertNoServerError("Initial empty cart");
    }

    @Test
    @DisplayName("Control: add valid item to cart should succeed")
    void addValidQuantityNavigatesToCartAndUpdatesTotal() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));
        Assertions.assertTrue(text(CART_TOTAL).contains("400.000"));
        assertNoServerError("Add valid quantity");
    }

    @Test
    void addZeroQuantityShowsError() {
        addToCartFromDetail(17, "0");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("ChiTietSanPham.aspx?ID=17"));
        Assertions.assertFalse(text(DETAIL_ERROR).isBlank());
        assertNoServerError("Add zero quantity");
    }

    @Test
    void addNonNumericQuantityShowsError() {
        addToCartFromDetail(17, "abc");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("ChiTietSanPham.aspx?ID=17"));
        Assertions.assertFalse(text(DETAIL_ERROR).isBlank());
        assertNoServerError("Add non-numeric quantity");
    }

    @Test
    void addNegativeQuantityShowsError() {
        addToCartFromDetail(17, "-1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("ChiTietSanPham.aspx?ID=17"));
        Assertions.assertFalse(text(DETAIL_ERROR).isBlank());
        assertNoServerError("Add negative quantity");
    }

    @Test
    void addDecimalQuantityShowsError() {
        addToCartFromDetail(17, "1.5");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("ChiTietSanPham.aspx?ID=17"));
        Assertions.assertFalse(text(DETAIL_ERROR).isBlank());
        assertNoServerError("Add decimal quantity");
    }

    @Test
    void updateQuantityInCartRecalculatesTotal() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        setValue(CART_QTY_0, "3");
        clickable(CART_UPDATE_0).click();

        Assertions.assertTrue(text(CART_TOTAL).contains("1,200.000"));
        assertNoServerError("Update quantity to 3");
    }

    @Test
    void updateQuantityWithInvalidValueShowsError() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        setValue(CART_QTY_0, "abc");
        clickable(CART_UPDATE_0).click();

        Assertions.assertTrue(hasText(CART_MESSAGE));
        assertNoServerError("Update quantity non-numeric");
    }

    @Test
    void cartUpdateNegativeQuantityMustBeRejectedWithoutServerError() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        setValue(CART_QTY_0, "-1");
        clickable(CART_UPDATE_0).click();

        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));
        assertNoServerError("Update quantity negative");
        Assertions.assertTrue(hasText(CART_MESSAGE) || hasText(CART_EMPTY_LABEL));
    }

    @Test
    void cartUpdateDecimalQuantityMustBeRejectedWithoutServerError() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        setValue(CART_QTY_0, "1.5");
        clickable(CART_UPDATE_0).click();

        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));
        assertNoServerError("Update quantity decimal");
        Assertions.assertTrue(hasText(CART_MESSAGE));
    }

    @Test
    void updateQuantityToZeroRemovesItem() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        setValue(CART_QTY_0, "0");
        clickable(CART_UPDATE_0).click();

        Assertions.assertTrue(text(CART_EMPTY_LABEL).contains("Kh"));
        assertNoServerError("Update quantity to zero");
    }

    @Test
    void deleteSingleItemFromCart() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        clickable(By.xpath("//input[contains(@onclick,'Delete$0')]")).click();
        Assertions.assertTrue(text(CART_EMPTY_LABEL).contains("Kh"));
        assertNoServerError("Delete item from cart");
    }

    @Test
    void clearCartButtonWorks() {
        addToCartFromDetail(17, "2");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        clickable(CART_CLEAR).click();
        Assertions.assertTrue(text(CART_EMPTY_LABEL).contains("Kh"));
        Assertions.assertTrue(text(CART_TOTAL).contains("0"));
        assertNoServerError("Clear cart");
    }

    @Test
    void continueShoppingFromCartNavigatesToCatalog() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        clickable(By.id("ContentPlaceHolder1_btnTiepTucMuaHang")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Kinhmat.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Kinhmat.aspx"));
        assertNoServerError("Continue shopping");
    }

    @Test
    void checkoutWithoutLoginShowsWarning() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        clickable(CART_CHECKOUT).click();
        Assertions.assertFalse(text(CART_CHECKOUT_MESSAGE).isBlank());
        assertNoServerError("Checkout without login");
    }

    @Test
    void addTwoDifferentProductsShowsTwoRowsAndCombinedTotal() {
        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));
        addToCartFromDetail(18, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));

        List<WebElement> qtyInputs = driver.findElements(By.cssSelector("input[id^='ContentPlaceHolder1_gvGioHang_txtSoLuong_']"));
        Assertions.assertEquals(2, qtyInputs.size());
        Assertions.assertTrue(text(CART_TOTAL).contains("600.000"));
        assertNoServerError("Two products in cart");
    }
}
