package com.memberservice.presentation

import com.memberservice.application.MemberFacade
import com.memberservice.presentation.dto.MemberDto
import com.memberservice.presentation.mapper.MemberDtoMapper
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
class MemberController(
    private val memberFacade: MemberFacade
) {
    @PostMapping
    fun register(@RequestBody register: MemberDto.Register): String {
        val memberCommand = MemberDtoMapper.of(register)
        memberFacade.register(memberCommand)
        return ""
    }

    @GetMapping("/{memberId}/tags")
    fun getTagsOfMember(@PathVariable memberId: String): List<String> {
        return memberFacade.getTagsOfMember(memberId)
    }

    @GetMapping("/tags")
    fun getTags(): List<String> {
        return memberFacade.getTags()
    }
}