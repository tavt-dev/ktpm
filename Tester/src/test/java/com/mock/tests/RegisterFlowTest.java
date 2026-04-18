package com.mock.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

class RegisterFlowTest extends BaseUiTest {

    private static final By USERNAME = By.id("ContentPlaceHolder1_txtTaiKhoan");
    private static final By PASSWORD = By.id("ContentPlaceHolder1_txtMatKhau");
    private static final By FULLNAME = By.id("ContentPlaceHolder1_txtHoTen");
    private static final By BIRTH = By.id("ContentPlaceHolder1_txtNamSinh");
    private static final By GENDER = By.id("ContentPlaceHolder1_dllGioiTinh");
    private static final By EMAIL = By.id("ContentPlaceHolder1_txtEmail");
    private static final By PHONE = By.id("ContentPlaceHolder1_txtSdt");
    private static final By ADDRESS = By.id("ContentPlaceHolder1_txtDiaChi");
    private static final By SUBMIT = By.id("ContentPlaceHolder1_btDangky");
    private static final By MESSAGE = By.id("ContentPlaceHolder1_lblThongBao");
    private static final By ERROR = By.id("ContentPlaceHolder1_lblError");

    private static final String VALID_BIRTH = "1999-01-01";
    private static final String VALID_GENDER = "Nam";
    private static final String VALID_PHONE = "0911222333";
    private static final String VALID_ADDRESS = "Ha Noi";
    private static final String VALID_PASSWORD = "123456";

    private record RegisterPayload(
            String username,
            String password,
            String fullName,
            String birth,
            String gender,
            String email,
            String phone,
            String address
    ) {}

    private RegisterPayload validPayload(String prefix) {
        String username = uniqueUser(prefix);
        return new RegisterPayload(
                username,
                VALID_PASSWORD,
                STANDARD_FULL_NAME,
                VALID_BIRTH,
                VALID_GENDER,
                username + "@test.com",
                VALID_PHONE,
                VALID_ADDRESS
        );
    }

    private RegisterPayload withUsername(RegisterPayload p, String username) {
        return new RegisterPayload(username, p.password, p.fullName, p.birth, p.gender, p.email, p.phone, p.address);
    }

    private RegisterPayload withPassword(RegisterPayload p, String password) {
        return new RegisterPayload(p.username, password, p.fullName, p.birth, p.gender, p.email, p.phone, p.address);
    }

    private RegisterPayload withFullName(RegisterPayload p, String fullName) {
        return new RegisterPayload(p.username, p.password, fullName, p.birth, p.gender, p.email, p.phone, p.address);
    }

    private RegisterPayload withBirth(RegisterPayload p, String birth) {
        return new RegisterPayload(p.username, p.password, p.fullName, birth, p.gender, p.email, p.phone, p.address);
    }

    private RegisterPayload withEmail(RegisterPayload p, String email) {
        return new RegisterPayload(p.username, p.password, p.fullName, p.birth, p.gender, email, p.phone, p.address);
    }

    private RegisterPayload withPhone(RegisterPayload p, String phone) {
        return new RegisterPayload(p.username, p.password, p.fullName, p.birth, p.gender, p.email, phone, p.address);
    }

    private RegisterPayload withAddress(RegisterPayload p, String address) {
        return new RegisterPayload(p.username, p.password, p.fullName, p.birth, p.gender, p.email, p.phone, address);
    }

    private void submitRegisterForm(RegisterPayload payload) {
        open("Dangky.aspx");
        setValue(USERNAME, payload.username);
        setValue(PASSWORD, payload.password);
        setValue(FULLNAME, payload.fullName);
        setValue(BIRTH, payload.birth);
        new Select(visible(GENDER)).selectByVisibleText(payload.gender);
        setValue(EMAIL, payload.email);
        setValue(PHONE, payload.phone);
        setValue(ADDRESS, payload.address);
        clickable(SUBMIT).click();
    }

    private String safeText(By by) {
        try {
            return driver.findElement(by).getText().trim();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    private String validationText() {
        return (safeText(MESSAGE) + " " + safeText(ERROR)).trim();
    }

    private void assertRejected(String reason) {
        Assertions.assertTrue(driver.getCurrentUrl().contains("Dangky.aspx"), reason + " - must stay on register page");
        Assertions.assertFalse(validationText().isBlank(), reason + " - must show validation/error message");
    }

    private String usernameWithLength(int length) {
        String base = uniqueUser("u");
        StringBuilder sb = new StringBuilder(base);
        while (sb.length() < length) {
            sb.append('x');
        }
        return sb.substring(0, length);
    }

    @Test
    @DisplayName("Control: valid register payload should pass")
    void registerWithValidDataSucceeds() {
        submitRegisterForm(validPayload("reg_ok_"));
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
    }

    @Test
    void registerRequiresUsername() {
        submitRegisterForm(withUsername(validPayload("reg_req_user_"), ""));
        assertRejected("Missing username");
    }

    @Test
    void registerRequiresPassword() {
        submitRegisterForm(withPassword(validPayload("reg_req_pwd_"), ""));
        assertRejected("Missing password");
    }

    @Test
    void registerRequiresFullName() {
        submitRegisterForm(withFullName(validPayload("reg_req_name_"), ""));
        assertRejected("Missing full name");
    }

    @Test
    void registerRequiresBirthDate() {
        submitRegisterForm(withBirth(validPayload("reg_req_birth_"), ""));
        assertRejected("Missing birth date");
    }

    @Test
    void registerRequiresEmail() {
        submitRegisterForm(withEmail(validPayload("reg_req_email_"), ""));
        assertRejected("Missing email");
    }

    @Test
    void registerRequiresPhone() {
        submitRegisterForm(withPhone(validPayload("reg_req_phone_"), ""));
        assertRejected("Missing phone");
    }

    @Test
    void registerRequiresAddress() {
        submitRegisterForm(withAddress(validPayload("reg_req_address_"), ""));
        assertRejected("Missing address");
    }

    @Test
    void registerDuplicateUsernameShowsError() {
        String username = uniqueUser("dup_reg_");
        registerUser(username, VALID_PASSWORD);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        logoutIfLoggedIn();

        RegisterPayload payload = withUsername(validPayload("dup_payload_"), username);
        submitRegisterForm(payload);
        assertRejected("Duplicate username");
    }

    @Test
    void registerPasswordLengthFiftyIsAccepted() {
        RegisterPayload payload = withPassword(validPayload("reg_pwd50_"), "p".repeat(50));
        submitRegisterForm(payload);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
    }

    @ParameterizedTest(name = "Password ''{0}'' must be rejected as too short")
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void tooShortPasswordsMustBeRejected(String shortPassword) {
        RegisterPayload payload = withPassword(validPayload("strict_pwd_short_"), shortPassword);
        submitRegisterForm(payload);
        assertRejected("Too short password");
    }

    @Test
    void tooLongPasswordMustBeRejected() {
        RegisterPayload payload = withPassword(validPayload("strict_pwd_long_"), "p".repeat(51));
        submitRegisterForm(payload);
        assertRejected("Too long password");
    }

    @Test
    void registerUsernameLengthFiftyIsAccepted() {
        RegisterPayload payload = withUsername(validPayload("reg_user50_"), usernameWithLength(50));
        submitRegisterForm(payload);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
    }

    @Test
    void tooLongUsernameMustBeRejected() {
        RegisterPayload payload = withUsername(validPayload("strict_user_long_"), usernameWithLength(51));
        submitRegisterForm(payload);
        assertRejected("Too long username");
    }

    @Test
    void registerPhoneLengthFiftyIsAccepted() {
        RegisterPayload payload = withPhone(validPayload("reg_phone50_"), "1".repeat(50));
        submitRegisterForm(payload);
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("Default.aspx"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
    }

    @Test
    void tooLongPhoneMustBeRejected() {
        RegisterPayload payload = withPhone(validPayload("strict_phone_long_"), "1".repeat(51));
        submitRegisterForm(payload);
        assertRejected("Too long phone");
    }

    @ParameterizedTest(name = "Invalid email ''{0}'' must be rejected")
    @ValueSource(strings = {"invalid_email_format", "abc", "abc@", "abc@domain"})
    void invalidEmailFormatsMustBeRejected(String invalidEmail) {
        RegisterPayload payload = withEmail(validPayload("strict_mail_"), invalidEmail);
        submitRegisterForm(payload);
        assertRejected("Invalid email format");
    }

    @ParameterizedTest(name = "Invalid phone ''{0}'' must be rejected")
    @ValueSource(strings = {"123", "09ab223333", "0911-222-333"})
    void invalidPhonesMustBeRejected(String invalidPhone) {
        RegisterPayload payload = withPhone(validPayload("strict_phone_"), invalidPhone);
        submitRegisterForm(payload);
        assertRejected("Invalid phone");
    }

    @Test
    void futureBirthDateMustBeRejected() {
        RegisterPayload payload = withBirth(validPayload("strict_birth_"), "2099-01-01");
        submitRegisterForm(payload);
        assertRejected("Future birth date");
    }
}
