package com.example.schoolmanagment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;

    @NotEmpty(message = "Area can't be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;

    @NotEmpty(message = "Street can't be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @NotNull(message = "Building number can't be null")
    @Positive(message = "Building number must be greater than 0")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
