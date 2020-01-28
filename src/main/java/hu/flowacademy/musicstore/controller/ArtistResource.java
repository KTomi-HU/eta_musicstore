package hu.flowacademy.musicstore.controller;

import hu.flowacademy.musicstore.model.Artist;
import hu.flowacademy.musicstore.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistResource {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/artists")
    public List<Artist> getArtists() {
        return artistService.findAll();
    }

    @PostMapping("/artist")
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.create(artist);
    }

    @PutMapping("/artist")
    public Artist updateArtist(@RequestBody Artist artist) {
        return artistService.update(artist);
    }

    @DeleteMapping("/artist/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.ok().build();
    }
}
