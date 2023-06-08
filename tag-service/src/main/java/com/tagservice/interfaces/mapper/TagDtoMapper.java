package com.tagservice.interfaces.mapper;

import com.tagservice.domain.command.TagCommand;
import com.tagservice.interfaces.dto.RequestTagDto;
import com.tagservice.interfaces.dto.TagDto;

public class TagDtoMapper {
    public static TagCommand of(RequestTagDto.Register register) {
        TagDto tagDto = new TagDto(register.getTagName());
        return tagDto.toCommand();
    }
}
