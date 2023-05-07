package com.memberservice.presentation.mapper

import com.memberservice.domain.command.MemberCommand
import com.memberservice.presentation.dto.MemberDto


class MemberDtoMapper {
    companion object {
        fun of(request: MemberDto.Register): MemberCommand.Register =
            MemberCommand.Register(
                email = request.email,
                password = request.password,
            )
    }
}