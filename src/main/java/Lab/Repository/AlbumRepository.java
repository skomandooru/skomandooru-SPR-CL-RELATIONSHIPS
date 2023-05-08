package Lab.Repository;

import Lab.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JPARepository that will be used to interact with our Album entity.
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
