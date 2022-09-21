package com.example.school.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Grade {
    A(5),
    B(4),
    C(3),
    D(2),
    E(1);

    private int value;
}
