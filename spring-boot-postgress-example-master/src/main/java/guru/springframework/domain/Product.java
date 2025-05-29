package guru.springframework.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;


@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long _id;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="imageUrl")
    private String imageUrl;

}
