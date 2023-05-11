package Lab.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * This is an ORM entity for an Artist. Artists have a one-to-many relationship with albums (one artist can produce
 * many albums.) This is reflected in the @OneToMany annotation. Spring associate the albums field with a foreign
 * key in the Album table, and if we wish to find the albums written by a particular artist, JPA will perform a join
 * with the Album table to retrieve the artists. All that is needed to retrieve a List of the related albums is to call
 * the method artist.getAlbums().
 *
 * For the sake of brevity, Lombok is also used to automatically generate boilerplate code.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Artist {
    //    The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistId;
    private String name;
    /**
     * There is one artist for many albums.
     * They will be connected via a foreign key by the name "album_fk", belonging to the Album table.
     * Spring will automatically perform the logic needed to join the Album and Artist table to get related albums.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_fk")
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
    }
    /**
     * A custom toString is provided that avoids recursively serializing related entities.
     */
    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", name='" + name + '\'' +
                ", albums=" + albums +
                '}';
    }
}
