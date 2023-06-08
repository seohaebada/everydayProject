package com.tagservice.domain.command;

import com.tagservice.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagCommand {
    private long tagId;
    private String tagName;

    public Tag toEntity() {
        return new Tag(this);
    }
}
