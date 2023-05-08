package Lab.Service;

import Lab.Model.Album;
import Lab.Model.Song;
import Lab.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class used to demonstrate ORM functionality for related entities.
 * This leverages the stereotype annotation @Service, which functionally is the same as @Component.
 * There is no need to modify anything in this class.
 */
@Service
public class AlbumService {

    AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }
    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }
    public Song addSongToAlbum(long albumId, Song song){
        Album album = albumRepository.findById(albumId).get();
        album.getSongs().add(song);
        albumRepository.save(album);
        return song;
    }

}
