package com.accountserver.interfaces

import com.accountserver.application.AccountFacade
import com.accountserver.interfaces.dto.AccountDto
import com.accountserver.interfaces.mapper.AccountDtoMapper
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/account")
class AccountController(
    private val accountFacade: AccountFacade,
) {
    /**
     * 회원가입
     */
    @PostMapping
    fun signUpSubmit(
        @RequestBody signUpForm: AccountDto.SignUpForm
    ) {
        accountFacade.processNewAccount(AccountDtoMapper.of(signUpForm))
    }
}