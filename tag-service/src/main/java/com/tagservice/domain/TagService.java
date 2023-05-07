package com.tagservice.domain;

import com.tagservice.domain.command.TagCommand;
import com.tagservice.infrastructure.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Mono<Tag> registerTag(TagCommand tagCommand) {
        Tag tag = tagCommand.toEntity();
        return tagRepository.save(tag);
    }

    public Flux<Tag> getTags() {
        return tagRepository.findAll();
    }
}
