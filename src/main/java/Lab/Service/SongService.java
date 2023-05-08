package Lab.Service;

import Lab.Model.Album;
import Lab.Model.Artist;
import Lab.Model.Song;
import Lab.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class used to demonstrate ORM functionality for related entities.
 * This leverages the stereotype annotation @Service, which functionally is the same as @Component.
 * There is no need to modify anything in this class.
 */
@Service
public class SongService {

    SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public Song addSong(Song song){
        return songRepository.save(song);
    }
    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }


}
