package com.memberservice.domain

import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


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
            .bodyToFlux(String::class.java)
            .collectList()

        val tagList = tagListMono.block() ?: emptyList()

        tagListMono.subscribe { tagList: List<String?> ->
            println(
                tagList.size
            )
        }

        return tagList.map { tagList -> tagList }
    }
}