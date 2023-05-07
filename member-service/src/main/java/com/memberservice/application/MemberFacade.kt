package com.memberservice.application

import com.memberservice.domain.MemberService
import com.memberservice.domain.command.MemberCommand
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class MemberFacade(
    private val memberService: MemberService
) {
    fun register(member: MemberCommand.Register) {
        memberService.register(member)
    }
}