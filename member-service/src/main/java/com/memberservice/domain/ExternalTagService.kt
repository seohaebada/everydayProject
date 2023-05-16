package com.memberservice.domain

import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.util.stream.Collectors


@Service
@RequiredArgsConstructor
class ExternalTagService(
    private val webClient: WebClient
) {
    companion object {
        val log: Logger = LoggerFactory.getLogger(ExternalTagService::class.java)
    }

    fun getTagsOfMember(memberId: String): List<String> {
        val tagListMono: Mono<List<String>> = webClient
            .get()
            .uri("http://localhost:7070/tag/{memberId}", memberId)
            .retrieve()
            .bodyToMono<List<String>>(object : ParameterizedTypeReference<List<String>>() {})

        return tagListMono.block() ?: emptyList()
    }
}