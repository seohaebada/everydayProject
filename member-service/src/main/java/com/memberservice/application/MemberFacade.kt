package com.memberservice.application

import com.memberservice.domain.MemberService
import com.memberservice.domain.TagService
import com.memberservice.domain.command.MemberCommand
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class MemberFacade(
    private val memberService: MemberService,
    private val tagService: TagService
) {
    fun register(member: MemberCommand.Register) {
        memberService.register(member)
    }

    fun getTagsOfMember(memberId: String): List<String> {
        return tagService.getTagsOfMember(memberId);
    }
}