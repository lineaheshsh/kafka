package com.kafka.boot.kafka.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDto {

    private String category;
    private String company;
    private String team;

    @Builder
    public MessageDto(String category, String company, String team) {
        this.category = category;
        this.company = company;
        this.team = team;
    }
}
