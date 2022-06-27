package com.efficom.tpfinal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Boxer {

    @Id
    private UUID id = randomUUID();
    private String lastName;
    private String firstName;
}
