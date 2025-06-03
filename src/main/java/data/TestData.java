package data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][] {
                {"wronguser", "Test@123", true, false},  // očekujemo poruku
                {"testuser", "wrongpass", true, false},  // očekujemo poruku
                {"", "Test@123", false, true},           // očekujemo crveni okvir
                {"testuser", "", false, true},           // očekujemo crveni okvir
                {"", "", false, true}                    // očekujemo crveni okvir
        };
    }
    //{username, password, expectErrorMessage, expectRedBorder}

}
