package com.github.andreygfranca.accountspayable.api.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.andreygfranca.accountspayable.api.v1.BasePath;
import com.github.andreygfranca.accountspayable.api.v1.dto.AccountPayableDTO;
import com.github.andreygfranca.accountspayable.api.v1.dto.SettlementDTO;
import com.github.andreygfranca.accountspayable.api.v1.mapper.AccountPayableMapper;
import com.github.andreygfranca.accountspayable.domain.AccountPayable;
import com.github.andreygfranca.accountspayable.domain.Settlement;
import com.github.andreygfranca.accountspayable.ports.usecase.CreateAccountPayableUseCase;
import com.github.andreygfranca.accountspayable.ports.usecase.SettleAccountPayableUseCase;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Andrey Franca 
 */
@Api(tags = "AccountsPayable")
@RestController
@RequestMapping(BasePath.BASE_PATH + "accounts-payable")
public class AccountPayableResourceAdapter {

    private static final AccountPayableMapper MAPPER = new AccountPayableMapper();

    private CreateAccountPayableUseCase createAccountPayableUseCase;
    private SettleAccountPayableUseCase settleAccountPayableUseCase;

    public AccountPayableResourceAdapter(CreateAccountPayableUseCase createAccountPayableUseCase,
                                         SettleAccountPayableUseCase settleAccountPayableUseCase) {
        this.createAccountPayableUseCase = createAccountPayableUseCase;
        this.settleAccountPayableUseCase = settleAccountPayableUseCase;
    }

    @ApiOperation(value = "Create a new accounts payable")
    @PostMapping
    public ResponseEntity<AccountPayableDTO> create(
            @ApiParam(value = "Account Payable") @RequestBody AccountPayableDTO accountPayableDTO) {
        var input = MAPPER.map(accountPayableDTO, AccountPayable.class);

        var output = createAccountPayableUseCase.execute(input);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MAPPER.map(output, AccountPayableDTO.class));
    }

    @ApiOperation(value = "Settle an accounts payable")
    @PostMapping("/{id}/settle")
    public ResponseEntity<SettlementDTO> settle(
            @ApiParam(value = "Account Payable id") @PathVariable("id") String id,
            @ApiParam(value = "Settlement's information") @RequestBody SettlementDTO settlementDTO) {
        var input = MAPPER.map(settlementDTO, Settlement.class);

        Settlement output = settleAccountPayableUseCase.execute(input);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MAPPER.map(output, SettlementDTO.class));
    }

}