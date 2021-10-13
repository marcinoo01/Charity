package pl.mistela.model;

import lombok.*;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@Getter
@Setter
@ToString
@NoArgsConstructor
@ComponentScan

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
