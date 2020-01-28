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
public class Album {

    @Id
    @GeneratedValue(generator = "album_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "album_seq", allocationSize = 1, sequenceName = "album_seq")

    private Long id;

    private String title;

    private Long count;
}
