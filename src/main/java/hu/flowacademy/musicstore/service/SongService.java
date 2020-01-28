package hu.flowacademy.musicstore.service;

import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.model.Song;
import hu.flowacademy.musicstore.repository.ArtistRepository;
import hu.flowacademy.musicstore.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<Song> findAll() { return songRepository.findAll(); }

    public Song create(Song song) {
        if (song.getId() != null) {
            throw new ValidationException("Expected ID value is null");
        }
        validateSong(song);

        return songRepository.save(song);
    }

    private void validateSong(Song song) {
        if (StringUtils.isEmpty(song.getTitle())) {
            throw new ValidationException("Missing title");
        }
        if (song.getAlbum() == null || song.getArtist() == null || song.getGenre() == null || song.getYear() == null) {
            throw new ValidationException("Artist / Album / Genre value cannot be null");
        }
        if (song.getLength() <= 0) {
            throw new ValidationException("Length must be greater than zero");
        }
        if (song.getLyrics() == "") {
            song.setLyrics(null);
        }

    }

    public Song update(Song song) {
        if (song.getId() == null) {
            return create(song);
        }
        validateSong(song);

        return songRepository.save(song);
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}
