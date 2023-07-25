package kr.semanticker.projectboard.config;

import kr.semanticker.projectboard.domain.UserAccount;
import kr.semanticker.projectboard.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(
                UserAccount.of(
                    "test",
                    "pw",
                    "test@email.com",
                    "test-nick",
                    "test-memo"
                )
        ));
    }
}
