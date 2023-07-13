package com.accountserver.domain

import com.accountserver.domain.command.AccountCommand
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountStore: AccountStore,
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    /**
     * 회원가입
     */
    fun processNewAccount(signUpForm: AccountCommand.SignUpForm) {
        /* 신규 회원 저장 */
        saveNewAccount(signUpForm)
    }

    private fun saveNewAccount(signUpForm: AccountCommand.SignUpForm) {
        /* account entity */
        val account: Account = signUpForm.toEntity()
        accountStore.saveNewAccount(account)
    }
}