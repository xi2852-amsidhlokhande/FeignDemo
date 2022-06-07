package com.amsidh.mvc.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Person {
    private Integer id;
    private String name;
}
