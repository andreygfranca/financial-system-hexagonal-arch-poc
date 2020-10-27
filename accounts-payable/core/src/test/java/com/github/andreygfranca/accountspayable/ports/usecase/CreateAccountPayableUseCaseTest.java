package com.github.andreygfranca.accountspayable.ports.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.andreygfranca.accountspayable.domain.AccountPayableType;
import com.github.andreygfranca.accountspayable.domain.builder.AccountPayableBuilder;
import com.github.andreygfranca.accountspayable.ports.repository.AccountPayableRepository;

/**
 * @author Andrey Franca 
 */
@ExtendWith(MockitoExtension.class)
class CreateAccountPayableUseCaseTest {

    @InjectMocks
    private CreateAccountPayableUseCase useCase;

    @Mock
    private AccountPayableRepository repository;

    @Tag("uc-accounts-payable")
    @DisplayName("When create a Account Payable then assert was created")
    @Test
    public void testCreateAccountPayable() {
        // Arrange
        var accountPayable = AccountPayableBuilder
                .anAccountPayable()
                .withId(UUID.randomUUID())
                .withType(AccountPayableType.INVOICE)
                .withValue(new BigDecimal(100))
                .build();
        when(repository.save(accountPayable)).thenReturn(accountPayable);

        // Act
        var accountPayablePersisted = useCase.execute(accountPayable);

        // Assert
        assertThat(accountPayable).isEqualToComparingFieldByField(accountPayablePersisted);
    }

}