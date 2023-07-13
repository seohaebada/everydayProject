package com.accountserver.interfaces.dto

class AccountDto {
    data class SignUpForm(
        var nickname: String,
        val email: String,
        val password: String,
    )
}