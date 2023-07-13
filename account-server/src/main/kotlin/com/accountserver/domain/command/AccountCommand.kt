package com.accountserver.domain.command

import com.accountserver.domain.Account

class AccountCommand {
    data class SignUpForm(
        val nickname: String,
        val email: String,
        var password: String, // setter
    ) {
        fun toEntity() = Account(
            nickname = nickname,
            email = email,
            password = password,
        )
    }
}