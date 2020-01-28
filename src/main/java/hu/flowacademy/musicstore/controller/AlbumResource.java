package hu.flowacademy.musicstore.controller;

import hu.flowacademy.musicstore.model.Album;
import hu.flowacademy.musicstore.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> getAlbums() {
        return albumService.findAll();
    }

    @PostMapping("/album")
    public Album createAlbum(@RequestBody Album album) {
        return albumService.create(album);
    }

    @PutMapping("/album")
    public Album updateAlbum(@RequestBody Album album) {
        return albumService.update(album);
    }

    @DeleteMapping("/album/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.delete(id);
        return ResponseEntity.ok().build();
    }


}
