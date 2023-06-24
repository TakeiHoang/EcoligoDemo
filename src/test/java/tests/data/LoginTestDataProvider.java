package tests.data;

import org.testng.annotations.DataProvider;

public class LoginTestDataProvider {
    @DataProvider(name = "invalidUsernameTestDataList")
    public Object[][] usernameTestDataList() {
        return new Object[][]{
                {"test Account"},
                {"testAccount#!#"},
                {"1234testAccount"},
                {"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"},
                {" testAccount "},
                {"téstAccount"},
                {"admintestAccount"},
                {""}
        };
    }

    @DataProvider(name = "invalidEmailTestDataList")
    public Object[][] emailTestDataList() {
        return new Object[][]{
                {"invalid.email.com"},
                {"invalid@"},
                {"invalid@email"},
                {"test invalid@email.com"},
                {"test!@#invalid@email.com"},
                {"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz@email.com"},
                {"@email.com"},
                {"test@invalid!email.com"},
                {"test@email.invalidtld"},
                {"tést@email.com"},
                {""},
                {"a@email.com"},
                {"-admin@email.com"}
        };
    }

    @DataProvider(name = "invalidPasswordTestDataList")
    public Object[][] passwordTestDataList() {
        return new Object[][]{
                {"test Password"},
                {"!!@#()*$&%!&^%"},
                {"aaaaaaaa"},
                {" testPassword "},
                {""},
                {"abcdefgHijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef!hijklmnopqrstuvwxyz"},
                {"a"},
                {"********"},
                {"1234Pass"},
                {"téstPassword"}
        };
    }
}
