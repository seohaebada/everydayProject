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

    public Tag(TagCommand tagCommand) {
        this.tagId = tagCommand.getTagId();
        this.tagName = tagCommand.getTagName();
    }

    public TagCommand toCommand() {
        TagCommand tagCommand = new TagCommand();
        tagCommand.setTagId(this.tagId);
        tagCommand.setTagName(this.tagName);

        return tagCommand;
    }
}
