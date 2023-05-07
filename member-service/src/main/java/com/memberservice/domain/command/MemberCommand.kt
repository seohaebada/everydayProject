package com.memberservice.domain.command

import com.memberservice.domain.Member

class MemberCommand {
    data class Register(
        val email: String,
        val password: String,
    ) {
        fun toEntity() = Member(
            email = email,
            password = password
        )
    }
}