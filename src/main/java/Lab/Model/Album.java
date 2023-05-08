package Lab.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * This is an ORM entity for an Album. This entity is incomplete, and you will have to introduce the mappings through
 * which this Entity will be related to other entities via a foreign key. Albums ought to have a many-to-one mapping
 * with artists (many albums may be created by one artist) and a one-to-many mapping with songs (one album may have
 * many songs). Check out the other provided entities, Artist and Song, to see how the @OneToMany and @ManyToOne
 *
 * For the sake of brevity, Lombok is also used to automatically generate boilerplate code.
 */
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
    //    The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumId;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_fk")
    private Artist artist;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_fk")
    private List<Song> songs;

    public Album(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                ", songs=" + songs +
                '}';
    }
}























