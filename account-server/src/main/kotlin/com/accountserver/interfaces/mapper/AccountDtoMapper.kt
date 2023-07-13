package com.accountserver.interfaces.mapper

import com.accountserver.domain.command.AccountCommand
import com.accountserver.interfaces.dto.AccountDto

class AccountDtoMapper {
    companion object {
        fun of(signUpForm: AccountDto.SignUpForm): AccountCommand.SignUpForm =
            AccountCommand.SignUpForm(
                nickname = signUpForm.nickname,
                email = signUpForm.email,
                password = signUpForm.password
            )
    }
}