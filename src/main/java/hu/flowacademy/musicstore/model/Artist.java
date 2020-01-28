package hu.flowacademy.musicstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(generator = "artist_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "artist_seq", allocationSize = 1, sequenceName = "artist_seq")
    private Long id;

    private String firstName;

    private String lastName;
}
