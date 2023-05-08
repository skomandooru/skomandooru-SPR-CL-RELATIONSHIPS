package Lab.Repository;

import Lab.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JPARepository that will be used to interact with our Artist entity.
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
