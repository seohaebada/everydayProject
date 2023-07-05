package com.memberservice.domain

import com.memberservice.domain.command.MemberCommand
import com.memberservice.infrastructure.MemberRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun register(memberCommand: MemberCommand.Register) {
        val member = memberCommand.toEntity()
        memberRepository.save(member)
    }
}