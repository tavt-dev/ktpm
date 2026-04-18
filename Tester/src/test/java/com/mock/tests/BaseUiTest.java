package com.mock.tests;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BaseUiTest {
    protected static final String BASE_URL = "http://hauiproj.somee.com/";
    protected static final String STANDARD_FULL_NAME = "Ti\u1ec7n V\u0103n T\u00e1";

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = createDriver();
        wait = new WebDriverWait(driver, 20);
        try {
            driver.manage().window().maximize();
        } catch (UnsupportedOperationException ignored) {
            // HtmlUnit does not support real window operations.
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebDriver createDriver() {
        HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
        htmlUnitDriver.setJavascriptEnabled(true);
        return htmlUnitDriver;
    }

    protected void open(String path) {
        driver.get(BASE_URL + path);
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    protected WebElement visible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement clickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void setValue(By by, String value) {
        WebElement input = visible(by);
        input.clear();
        input.sendKeys(value);
    }

    protected String text(By by) {
        return visible(by).getText().trim();
    }

    protected boolean displayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected String uniqueUser(String prefix) {
        return prefix + System.currentTimeMillis();
    }

    protected void registerUser(String username, String password) {
        open("Dangky.aspx");
        setValue(By.id("ContentPlaceHolder1_txtTaiKhoan"), username);
        setValue(By.id("ContentPlaceHolder1_txtMatKhau"), password);
        setValue(By.id("ContentPlaceHolder1_txtHoTen"), STANDARD_FULL_NAME);
        setValue(By.id("ContentPlaceHolder1_txtNamSinh"), "1999-01-01");
        Select gender = new Select(visible(By.id("ContentPlaceHolder1_dllGioiTinh")));
        gender.selectByVisibleText("Nam");
        setValue(By.id("ContentPlaceHolder1_txtEmail"), username + "@testmail.com");
        setValue(By.id("ContentPlaceHolder1_txtSdt"), "0987654321");
        setValue(By.id("ContentPlaceHolder1_txtDiaChi"), "Ha Noi");
        clickable(By.id("ContentPlaceHolder1_btDangky")).click();
    }

    protected void loginUser(String username, String password) {
        open("Dangnhap.aspx");
        setValue(By.id("ContentPlaceHolder1_txtTaikhoan"), username);
        setValue(By.id("ContentPlaceHolder1_txtMatkhau"), password);
        clickable(By.id("ContentPlaceHolder1_btDangnhap")).click();
    }

    protected void logoutIfLoggedIn() {
        if (displayed(By.id("LinkDX"))) {
            clickable(By.id("LinkDX")).click();
            wait.until(webDriver -> displayed(By.id("LinkDN")));
        }
    }

    protected void addToCartFromDetail(int productId, String qty) {
        open("ChiTietSanPham.aspx?ID=" + productId);
        setValue(By.id("ContentPlaceHolder1_Datalist1_txtSoLuong_0"), qty);
        clickable(By.id("ContentPlaceHolder1_Datalist1_btnThemVaoGio_0")).click();
    }
}
