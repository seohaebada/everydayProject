package com.memberservice.domain

import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.core.publisher.Flux
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

    fun getTags(): List<String> {
        val tagListFlux: Flux<String> = webClient
            .get()
            .uri("http://localhost:7070/tag/tags")
            .retrieve()
            .bodyToFlux()

        /*
        [
          "태그 테스트2태그 테스트3태그 테스트4태그 테스트1"
        ]
         */
        return tagListFlux.collectList().block() ?: emptyList()
    }
}