package com.tagserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    private Long id;

    private String title;

    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    private String createdBy;

    @CreatedDate
    private LocalDateTime createdAt;
}
