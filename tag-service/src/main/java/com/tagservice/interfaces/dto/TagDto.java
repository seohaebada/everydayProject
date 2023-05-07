package com.tagservice.interfaces.dto;

import com.tagservice.domain.command.TagCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {
    private long tagId;
    private String tagName;

    public TagCommand toCommand() {
        TagCommand tagCommand = new TagCommand();
        tagCommand.setTagId(this.tagId);
        tagCommand.setTagName(this.tagName);

        return tagCommand;
    }
}
