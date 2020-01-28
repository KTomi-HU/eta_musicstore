package hu.flowacademy.musicstore.controller;

import hu.flowacademy.musicstore.model.Song;
import hu.flowacademy.musicstore.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SongResource {

    @Autowired
    private SongService songService;

    @GetMapping("/songs")
    public List<Song> getSongs() {
        return songService.findAll();
    }

    @PostMapping("/song")
    public Song createSong(@RequestBody Song song) {
        return songService.create(song);
    }

    @PutMapping("/song")
    public Song updateSong(@RequestBody Song song) {
        return songService.update(song);
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.ok().build();
    }
}
