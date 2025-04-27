package com.lotte.emp.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeRequest {
    private Long id;
    private String name;
    private String email;
    private String position;
    private Double salary;
}
