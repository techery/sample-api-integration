package io.techery.github.api.tests;

import org.testng.annotations.BeforeSuite;

import ie.corballis.fixtures.annotation.Fixture;
import io.techery.github.api.fixtures.UserCredential;
import io.techery.github.api.http.executor.AuthorizedActionExecutor;
import io.techery.github.api.user.model.User;


public class BaseTestWithSession extends BaseTest {

    @Fixture("default_user")
    UserCredential defaultUser;

    private static AuthorizedActionExecutor authorizedActionExecutor;

    @BeforeSuite
    public void prepareAuthorizedExecutor() throws Exception {
        injectFixtures();
        authorizedActionExecutor = as(defaultUser);
    }

    @Override
    protected AuthorizedActionExecutor provideActionExecutor() {
        return authorizedActionExecutor;
    }

    protected UserCredential authorizedUser() {
        return defaultUser;
    }

    protected User session() {
        return authorizedActionExecutor.getCurrentUser();
    }
}
