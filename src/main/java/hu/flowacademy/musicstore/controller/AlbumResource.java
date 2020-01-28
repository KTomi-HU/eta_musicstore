package hu.flowacademy.musicstore.controller;

import hu.flowacademy.musicstore.model.Album;
import hu.flowacademy.musicstore.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
