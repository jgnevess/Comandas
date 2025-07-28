package org.nevesdev.comanda.dto.bar;

import jakarta.persistence.Embedded;
import lombok.*;
import org.nevesdev.comanda.model.bar.Address;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BarCreate {

    private String barName;
    private Address address;
}
