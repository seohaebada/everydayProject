package com.zoneserver.domain;

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
public class Zone {
    @Id
    private Long id;

    private String city;

    private String localNameOfCity;

    private String province;

    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    private String createdBy;

    @CreatedDate
    private LocalDateTime createdAt;
}
