package com.accountserver.infrastructure

import com.accountserver.domain.Account
import com.accountserver.domain.AccountStore
import org.springframework.stereotype.Component

@Component
class AccountStoreImpl(
    private val accountRepository: AccountRepository
): AccountStore {
    override fun saveNewAccount(account: Account): Account {
        return accountRepository.save(account)
    }
}