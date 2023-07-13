package com.accountserver.application

import com.accountserver.domain.AccountService
import com.accountserver.domain.command.AccountCommand
import org.springframework.stereotype.Service

@Service
class AccountFacade(
    private val accountService: AccountService,
) {
    fun processNewAccount(signUpForm: AccountCommand.SignUpForm) {
        accountService.processNewAccount(signUpForm);
    }
}