package Lab.Model;

import lombok.*;

import javax.persistence.*;

/**
 * This is an ORM entity for a Song. Songs have a many-to-one relationship with albums (there are many songs in one
 * album). This is reflected in the many-to-one annotation. Spring will associate the album field with a foreign key
 * in the database table, and if we wish to find the album of a particular song, JPA will perform a join to retrieve
 * the album data. All that is needed to retrieve the album data of any song is to call the method song.getAlbum().
 *
 * For the sake of brevity, Lombok is also used to automatically generate boilerplate code.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Song {
    //    The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long songId;
    private String title;
    /**
     * There is many songs for one album.
     * They will be connected via a foreign key by the name "album_fk", belonging to the song table.
     * Spring will automatically perform the logic needed to join the Song and Album tables to get related albums.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_fk")
    private Album album;

    public Song(String title) {
        this.title = title;
    }
    /**
     * A custom toString is provided that avoids recursively serializing related entities.
     */
    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                '}';
    }
}
