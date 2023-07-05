package com.tagservice.domain;

import com.tagservice.domain.command.TagCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    private long tagId;
    private String tagName;
    private String createdBy;

    public Tag(TagCommand tagCommand) {
        this.tagId = tagCommand.getTagId();
        this.tagName = tagCommand.getTagName();
    }

    public TagCommand toCommand() {
        return new TagCommand(this.tagId, this.tagName);
    }
}
