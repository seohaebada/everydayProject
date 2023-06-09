package com.tagservice.interfaces;

import com.tagservice.application.TagFacade;
import com.tagservice.domain.command.TagCommand;
import com.tagservice.interfaces.dto.RequestTagDto;
import com.tagservice.interfaces.dto.TagDto;
import com.tagservice.interfaces.mapper.TagDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController("tagController")
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagFacade tagFacade;

    /**
     * TAG 신규 등록
     * @param requestBody
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TagDto> registerTag(@RequestBody RequestTagDto.Register requestBody) {
        TagCommand tagCommand = TagDtoMapper.of(requestBody);
        Mono<TagCommand> tagCommandMono = tagFacade.registerTag(tagCommand);

        return tagCommandMono.map(tag -> new TagDto(tag.getTagId(), tag.getTagName()));
    }

    /**
     * 태그 리스트 조회
     * @return
     */
    @GetMapping
    public Flux<TagDto> getTags() {
        Flux<TagCommand> tagCommandFlux = tagFacade.getTags();

        return tagCommandFlux.map(tag -> new TagDto(tag.getTagId(), tag.getTagName()));
    }

    /**
     * 태그 리스트 조회
     * @return
     */
    @GetMapping("/{memberId}")
    public Mono<List<String>> getTagsOfMember(@PathVariable String memberId) {
        Mono<List<TagCommand>> tagCommandListMono = tagFacade.getTagsOfMember(memberId);

        return tagCommandListMono
                .flatMapIterable(tagList -> tagList)
                .map(TagCommand::getTagName)
                .collectList();
    }

    /**
     * 태그 리스트 조회
     * @return
     */
    @GetMapping("/tags")
    public Flux<String> getTagsList() {
        Flux<TagCommand> tagCommandListFlux = tagFacade.getTags();

        return tagCommandListFlux.map(TagCommand::getTagName);
    }
}
