package com.efficom.tpfinal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fight {

    @Id
    public UUID uuid_fight = randomUUID();
    @ManyToOne(fetch = FetchType.EAGER)
    private Boxer firstFighter;
    @ManyToOne(fetch = FetchType.EAGER)
    private Boxer secondFighter;
    private String place;
    private String result;
}
