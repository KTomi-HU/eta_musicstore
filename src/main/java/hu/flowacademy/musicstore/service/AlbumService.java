package hu.flowacademy.musicstore.service;

import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.model.Album;
import hu.flowacademy.musicstore.repository.AlbumRepository;
import hu.flowacademy.musicstore.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AlbumService {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    public List<Album> findAll() {return albumRepository.findAll(); }

    public Album create(Album album) {
        if (album.getId() != null) {
            throw new ValidationException("Expected ID value is null");
        }
        validateAlbum(album);

        return albumRepository.save(album);
    }

    private void validateAlbum(Album album) {
        if (StringUtils.isEmpty(album.getTitle())) {
            throw new ValidationException("Missing title");
        }
        if (album.getCount() <= 0) {
            throw new ValidationException("Value of count must be greater than zero");
        }
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
