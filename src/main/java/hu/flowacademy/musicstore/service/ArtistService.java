package hu.flowacademy.musicstore.service;

import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.model.Artist;
import hu.flowacademy.musicstore.repository.AlbumRepository;
import hu.flowacademy.musicstore.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public List<Artist> findAll() {return artistRepository.findAll(); }

    public Artist create(Artist artist) {
        if (artist.getId() != null) {
            throw new ValidationException("Expected ID value is null");
        }
        validateArtist(artist);

        return artistRepository.save(artist);
    }

    private void validateArtist(Artist artist) {
        if (StringUtils.isEmpty(artist.getFirstName()) || StringUtils.isEmpty(artist.getLastName())) {
            throw new ValidationException("Missing first- or lastname");
        }
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
    }

}
