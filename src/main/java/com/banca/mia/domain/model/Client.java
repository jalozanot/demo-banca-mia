package com.banca.mia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client {
    private Long id;
    private String dni;
    private int numberIdentification;
    private String name;
    private String lastName;
    private Date creationDate;
}
