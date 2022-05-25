package guru.qa.tests;

import guru.qa.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Disabled
public class OwnerTests {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        @Test
        @Tag("owner")
        void loginTest() {
            String login = config.login();
            String password = config.password();
        }
}
