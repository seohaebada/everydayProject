package com.tagservice.domain.command;

import com.tagservice.domain.Tag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagCommand {
    private long tagId;
    private String tagName;

    public Tag toEntity() {
        return new Tag(this);
    }
}
