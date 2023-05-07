package com.tagservice.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

public class RequestTagDto {
    @Getter
    @Setter
    public static class Register {
        private String tagName;
    }
}
