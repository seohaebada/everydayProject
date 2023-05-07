package com.tagservice.application;

import com.tagservice.domain.Tag;
import com.tagservice.domain.TagService;
import com.tagservice.domain.command.TagCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TagFacade {
    private final TagService tagService;

    public Mono<TagCommand> registerTag(TagCommand tagCommand) {
        Mono<Tag> tagMono = tagService.registerTag(tagCommand);

        return tagMono.map(Tag::toCommand);
    }

    public Flux<TagCommand> getTags() {
        Flux<Tag> tagFlux = tagService.getTags();
        return tagFlux.map(Tag::toCommand);
    }
}
