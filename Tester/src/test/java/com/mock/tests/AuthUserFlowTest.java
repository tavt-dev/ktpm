package com.mock.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class AuthUserFlowTest extends BaseUiTest {

    private static final By USERNAME = By.id("ContentPlaceHolder1_txtTaikhoan");
    private static final By PASSWORD = By.id("ContentPlaceHolder1_txtMatkhau");
    private static final By SUBMIT = By.id("ContentPlaceHolder1_btDangnhap");
    private static final By MESSAGE = By.id("ContentPlaceHolder1_txtThongbaoDN");
    private static final By LOGIN_LINK = By.id("LinkDN");
    private static final By LOGOUT_LINK = By.id("LinkDX");
    private static final By GREETING = By.id("lblHTTK");

    private void submitLogin(String username, String password) {
        open("Dangnhap.aspx");
        setValue(USERNAME, username);
        setValue(PASSWORD, password);
        clickable(SUBMIT).click();
    }

    private String safeText(By by) {
        try {
            return driver.findElement(by).getText().trim();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    private void assertRejected(String reason) {
        Assertions.assertTrue(driver.getCurrentUrl().contains("Dangnhap.aspx"),
                reason + " - must stay on login page");
        Assertions.assertFalse(displayed(LOGOUT_LINK),
                reason + " - must not be logged in");
        Assertions.assertTrue(displayed(LOGIN_LINK),
                reason + " - login link must stay visible");
        Assertions.assertFalse(safeText(MESSAGE).isBlank(),
                reason + " - must show validation/error message");
    }

    @Test
    @DisplayName("Control: valid credentials should login successfully")
    void validCredentialsShouldLoginSuccessfully() {
        String username = uniqueUser("strict_login_ok_");
        String password = "123456";
        registerUser(username, password);
        wait.until(webDriver -> displayed(LOGOUT_LINK));
        logoutIfLoggedIn();

        loginUser(username, password);
        wait.until(webDriver -> displayed(LOGOUT_LINK));

        Assertions.assertTrue(displayed(LOGOUT_LINK));
        Assertions.assertFalse(displayed(LOGIN_LINK));
        Assertions.assertTrue(text(GREETING).contains(username));
    }

    @Test
    void emptyCredentialsMustBeRejected() {
        submitLogin("", "");
        assertRejected("Empty username/password");
    }

    @Test
    void emptyUsernameMustBeRejected() {
        submitLogin("", "123456");
        assertRejected("Empty username");
    }

    @Test
    void emptyPasswordMustBeRejected() {
        submitLogin("abc", "");
        assertRejected("Empty password");
    }

    @Test
    void unknownUsernameMustBeRejected() {
        submitLogin(uniqueUser("ghost_"), "123456");
        assertRejected("Unknown username");
    }

    @Test
    void wrongPasswordMustBeRejected() {
        String username = uniqueUser("strict_wrongpwd_");
        String password = "123456";
        registerUser(username, password);
        wait.until(webDriver -> displayed(LOGOUT_LINK));
        logoutIfLoggedIn();

        submitLogin(username, "654321");
        assertRejected("Wrong password");
    }

    @Test
    void passwordInputMustBeMasked() {
        open("Dangnhap.aspx");
        String type = visible(PASSWORD).getAttribute("type");
        Assertions.assertEquals("password", type.toLowerCase());
    }

    @ParameterizedTest(name = "SQLi payload in username ''{0}'' must be rejected")
    @ValueSource(strings = {"' OR 1=1 --", "admin'--", "\" OR \"1\"=\"1"})
    void sqlInjectionPayloadInUsernameMustBeRejected(String payload) {
        submitLogin(payload, "123456");
        assertRejected("SQL injection payload in username");

        String message = safeText(MESSAGE).toLowerCase();
        Assertions.assertFalse(message.contains("exception"));
        Assertions.assertFalse(message.contains("sql"));
    }

    @ParameterizedTest(name = "SQLi payload in password ''{0}'' must be rejected")
    @ValueSource(strings = {"' OR 1=1 --", "x' OR 'x'='x"})
    void sqlInjectionPayloadInPasswordMustBeRejected(String payload) {
        String username = uniqueUser("strict_sqlpwd_");
        registerUser(username, "123456");
        wait.until(webDriver -> displayed(LOGOUT_LINK));
        logoutIfLoggedIn();

        submitLogin(username, payload);
        assertRejected("SQL injection payload in password");

        String message = safeText(MESSAGE).toLowerCase();
        Assertions.assertFalse(message.contains("exception"));
        Assertions.assertFalse(message.contains("sql"));
    }

    @Test
    void registerThenLoginThenLogoutHappyPath() {
        String username = uniqueUser("user_");
        String password = "123456";

        registerUser(username, password);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        Assertions.assertTrue(displayed(LOGOUT_LINK));
        logoutIfLoggedIn();

        loginUser(username, password);
        wait.until(webDriver -> displayed(LOGOUT_LINK));

        Assertions.assertTrue(displayed(LOGOUT_LINK));
        Assertions.assertFalse(displayed(LOGIN_LINK));
        Assertions.assertFalse(text(GREETING).isBlank());

        clickable(LOGOUT_LINK).click();
        wait.until(webDriver -> displayed(LOGIN_LINK));
        Assertions.assertTrue(displayed(LOGIN_LINK));
    }

    @Test
    void loginFromHomeMenuWorks() {
        String username = uniqueUser("menu_login_");
        String password = "123456";

        registerUser(username, password);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        logoutIfLoggedIn();

        open("Default.aspx");
        clickable(LOGIN_LINK).click();
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Dangnhap.aspx"));
        setValue(USERNAME, username);
        setValue(PASSWORD, password);
        clickable(SUBMIT).click();

        wait.until(webDriver -> displayed(LOGOUT_LINK));
        Assertions.assertTrue(displayed(LOGOUT_LINK));
    }

    @Test
    void greetingAndLoginStatePersistAcrossPages() {
        String username = uniqueUser("persist_");
        String password = "123456";

        registerUser(username, password);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));

        Assertions.assertTrue(text(GREETING).contains(username));
        open("Kinhmat.aspx");
        Assertions.assertTrue(text(GREETING).contains(username));
        open("Giohang.aspx");
        Assertions.assertTrue(text(GREETING).contains(username));
        Assertions.assertTrue(displayed(LOGOUT_LINK));
    }
}
