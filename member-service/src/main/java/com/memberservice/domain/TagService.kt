package com.memberservice.domain

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


@Service
@RequiredArgsConstructor
class TagService(
    private val webClient: WebClient
) {
    fun getTagsOfMember(memberId: String): List<String> {
        val tagList: Mono<List<String>> = webClient
            .get()
            .uri("http://localhost:7070/tag/{memberId}", memberId)
            .retrieve()
            .bodyToFlux(String::class.java)
            .collectList()

        return tagList.block() ?: emptyList()
    }
}