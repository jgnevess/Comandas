package org.nevesdev.comanda.model.bar;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String barName;
    @Embedded
    private Address address;

    public Bar() {}

    public Bar(Long id, String barName, Address address) {
        this.id = id;
        this.barName = barName;
        this.address = address;
    }

    public Bar(String barName, Address address) {
        this.barName = barName;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return Objects.equals(barName, bar.barName) && Objects.equals(address, bar.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barName, address);
    }
}
