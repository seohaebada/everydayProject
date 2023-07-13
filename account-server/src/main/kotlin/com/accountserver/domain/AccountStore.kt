package com.accountserver.domain

interface AccountStore {
    fun saveNewAccount(account: Account): Account
}