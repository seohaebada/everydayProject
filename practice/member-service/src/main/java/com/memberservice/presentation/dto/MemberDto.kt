package com.memberservice.presentation.dto

class MemberDto {
    data class Register(
        val email: String,
        val password: String
    )
}