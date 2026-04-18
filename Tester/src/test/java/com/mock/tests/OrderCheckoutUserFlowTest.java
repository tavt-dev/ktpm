package com.mock.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

class OrderCheckoutUserFlowTest extends BaseUiTest {

    private static final By ORDER_NAME = By.id("ContentPlaceHolder1_dtlThongTinUser_txtTen_0");
    private static final By ORDER_PHONE = By.id("ContentPlaceHolder1_dtlThongTinUser_txtDienThoai_0");
    private static final By ORDER_EMAIL = By.id("ContentPlaceHolder1_dtlThongTinUser_txtEmail_0");
    private static final By ORDER_ADDRESS = By.id("ContentPlaceHolder1_dtlThongTinUser_txtDiaChi_0");
    private static final By ORDER_PAYMENT = By.id("ContentPlaceHolder1_dtlThongTinUser_ddlPhuongThuc_0");
    private static final By ORDER_NOTE = By.id("ContentPlaceHolder1_dtlThongTinUser_txtGhiChu_0");
    private static final By ORDER_SUBMIT = By.id("ContentPlaceHolder1_dtlThongTinUser_btnThanhToan_0");
    private static final By ORDER_MESSAGE = By.id("ContentPlaceHolder1_dtlThongTinUser_lblThongBao_0");
    private static final By ORDER_SUCCESS = By.id("ContentPlaceHolder1_lblThanhCong");
    private static final By ORDER_TOTAL = By.id("ContentPlaceHolder1_lblTongTien");
    private static final By ORDER_HOME_LINK = By.id("ContentPlaceHolder1_LinkTrangChu");
    private static final By CART_EMPTY = By.id("ContentPlaceHolder1_gvGioHang_Label1");

    private String safeText(By by) {
        try {
            return driver.findElement(by).getText().trim();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    private String openOrderPageForNewUserWithOneItem(String prefix) {
        String username = uniqueUser(prefix);
        String password = "123456";

        registerUser(username, password);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));

        addToCartFromDetail(17, "1");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Giohang.aspx"));
        clickable(By.id("ContentPlaceHolder1_btnThanhToan")).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Dathang.aspx"));
        return username;
    }

    private void fillOrderForm(String name, String phone, String email, String address, String payment, String note) {
        setValue(ORDER_NAME, name);
        setValue(ORDER_PHONE, phone);
        setValue(ORDER_EMAIL, email);
        setValue(ORDER_ADDRESS, address);
        new Select(visible(ORDER_PAYMENT)).selectByVisibleText(payment);
        setValue(ORDER_NOTE, note);
    }

    private void submitOrder() {
        clickable(ORDER_SUBMIT).click();
    }

    private void assertRejected(String reason) {
        Assertions.assertTrue(driver.getCurrentUrl().contains("Dathang.aspx"),
                reason + " - must stay on order page");
        Assertions.assertFalse(safeText(ORDER_SUCCESS).contains("thanh c"),
                reason + " - must not be successful order");
        Assertions.assertFalse(safeText(ORDER_MESSAGE).isBlank(),
                reason + " - must show validation message");
    }

    @Test
    void checkoutWhenLoggedInNavigatesToOrderPage() {
        openOrderPageForNewUserWithOneItem("order_nav_");
        Assertions.assertTrue(driver.getCurrentUrl().contains("Dathang.aspx"));
        Assertions.assertTrue(displayed(ORDER_SUBMIT));
    }

    @Test
    void orderPageShowsPrefilledCustomerInfoAndPaymentMethods() {
        String username = openOrderPageForNewUserWithOneItem("order_prefill_");

        Assertions.assertFalse(visible(ORDER_NAME).getAttribute("value").isBlank());
        Assertions.assertFalse(visible(ORDER_PHONE).getAttribute("value").isBlank());
        Assertions.assertFalse(visible(ORDER_EMAIL).getAttribute("value").isBlank());
        Assertions.assertFalse(visible(ORDER_ADDRESS).getAttribute("value").isBlank());
        Assertions.assertTrue(text(ORDER_TOTAL).contains("400.000"));
        Assertions.assertTrue(text(By.id("lblHTTK")).contains(username));

        Select paymentSelect = new Select(visible(ORDER_PAYMENT));
        List<String> options = paymentSelect.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        Assertions.assertTrue(options.stream().anyMatch(item -> item.toLowerCase().contains("ti")));
        Assertions.assertTrue(options.stream().anyMatch(item -> item.toLowerCase().contains("chuy")));
    }

    @Test
    void orderValidationRequiresReceiverName() {
        openOrderPageForNewUserWithOneItem("order_req_name_");
        fillOrderForm("", "0911222333", "buyer@test.com", "Ha Noi", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();
        assertRejected("Missing receiver name");
    }

    @Test
    void orderValidationRequiresPhone() {
        openOrderPageForNewUserWithOneItem("order_req_phone_");
        fillOrderForm(STANDARD_FULL_NAME, "", "buyer@test.com", "Ha Noi", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();
        assertRejected("Missing phone");
    }

    @Test
    void orderValidationRequiresEmail() {
        openOrderPageForNewUserWithOneItem("order_req_email_");
        fillOrderForm(STANDARD_FULL_NAME, "0911222333", "", "Ha Noi", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();
        assertRejected("Missing email");
    }

    @Test
    void orderValidationRequiresAddress() {
        openOrderPageForNewUserWithOneItem("order_req_addr_");
        fillOrderForm(STANDARD_FULL_NAME, "0911222333", "buyer@test.com", "", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();
        assertRejected("Missing address");
    }

    @Test
    void orderValidationRequiresNote() {
        openOrderPageForNewUserWithOneItem("order_req_note_");
        fillOrderForm(STANDARD_FULL_NAME, "0911222333", "buyer@test.com", "Ha Noi", "Ti\u1ec1n m\u1eb7t", "");
        submitOrder();
        assertRejected("Missing note");
    }

    @Test
    @DisplayName("Control: valid order payload should succeed")
    void successfulOrderWithCashShowsSuccessMessageAndHomeLink() {
        openOrderPageForNewUserWithOneItem("order_ok_cash_");
        fillOrderForm(STANDARD_FULL_NAME, "0911222333", "buyer@test.com", "Ha Noi", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();

        Assertions.assertTrue(safeText(ORDER_SUCCESS).toLowerCase().contains("th\u00e0nh c\u00f4ng"));
        Assertions.assertTrue(displayed(ORDER_HOME_LINK));
        Assertions.assertTrue(safeText(ORDER_TOTAL).isBlank());
    }

    @Test
    void successfulOrderWithBankTransferAlsoWorks() {
        openOrderPageForNewUserWithOneItem("order_ok_bank_");
        fillOrderForm(STANDARD_FULL_NAME, "0911222333", "buyer@test.com", "Ha Noi", "Chuy\u1ec3n kho\u1ea3n", "thanh toan ck");
        submitOrder();

        Assertions.assertTrue(safeText(ORDER_SUCCESS).toLowerCase().contains("th\u00e0nh c\u00f4ng"));
        Assertions.assertTrue(displayed(ORDER_HOME_LINK));
    }

    @Test
    void cartBecomesEmptyAfterSuccessfulOrder() {
        openOrderPageForNewUserWithOneItem("order_empty_after_");
        fillOrderForm(STANDARD_FULL_NAME, "0911222333", "buyer@test.com", "Ha Noi", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();

        open("Giohang.aspx");
        Assertions.assertTrue(text(CART_EMPTY).contains("Kh"));
        Assertions.assertTrue(text(By.id("ContentPlaceHolder1_lblTongTien")).contains("0"));
    }

    @ParameterizedTest(name = "Invalid phone ''{0}'' must be rejected")
    @ValueSource(strings = {"123", "09ab223333", "0911-222-333"})
    void invalidPhoneMustBeRejected(String invalidPhone) {
        openOrderPageForNewUserWithOneItem("order_invalid_phone_");
        fillOrderForm(STANDARD_FULL_NAME, invalidPhone, "buyer@test.com", "Ha Noi", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();
        assertRejected("Invalid phone");
    }

    @ParameterizedTest(name = "Invalid email ''{0}'' must be rejected")
    @ValueSource(strings = {"abc", "abc@", "abc@domain"})
    void invalidEmailMustBeRejected(String invalidEmail) {
        openOrderPageForNewUserWithOneItem("order_invalid_email_");
        fillOrderForm(STANDARD_FULL_NAME, "0911222333", invalidEmail, "Ha Noi", "Ti\u1ec1n m\u1eb7t", "giao nhanh");
        submitOrder();
        assertRejected("Invalid email");
    }

    @Test
    void orderPageMustRequireLogin() {
        open("Dathang.aspx");
        String source = driver.getPageSource().toLowerCase();
        boolean redirectedOrBlocked = driver.getCurrentUrl().contains("Dangnhap.aspx")
                || source.contains("vui l")
                || source.contains("dang nhap")
                || source.contains("\u0111\u0103ng nh\u1eadp");
        Assertions.assertTrue(redirectedOrBlocked, "Order page must require login");
    }

    @Test
    void checkoutWithEmptyCartMustNotCreateOrder() {
        String username = uniqueUser("order_empty_cart_");
        registerUser(username, "123456");
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        open("Giohang.aspx");
        Assertions.assertTrue(safeText(CART_EMPTY).contains("Kh"));

        open("Dathang.aspx");
        String total = safeText(ORDER_TOTAL);
        Assertions.assertTrue(total.isBlank() || total.contains("0"),
                "Order total should be empty or zero when cart is empty");
    }
}
