package Lab.Repository;

import Lab.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JPARepository that will be used to interact with our Song entity.
 */
public interface SongRepository extends JpaRepository<Song, Long> {

}
