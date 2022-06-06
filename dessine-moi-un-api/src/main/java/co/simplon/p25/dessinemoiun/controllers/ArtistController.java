package co.simplon.p25.dessinemoiun.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.p25.dessinemoiun.dtos.artist.ArtistCard;
import co.simplon.p25.dessinemoiun.dtos.artist.ArtistProfile;
import co.simplon.p25.dessinemoiun.dtos.artist.ArtistTop3;
import co.simplon.p25.dessinemoiun.services.ArtistService;

@RestController
@RequestMapping("artists")
public class ArtistController {

    private final ArtistService service;

    public ArtistController(ArtistService service) {
	this.service = service;
    }

    @GetMapping("/profile")
    public ArtistProfile getArtistProfile() {
	return service.getArtistProfile();
    }

    @GetMapping("/cards")
    public List<ArtistCard> getArtistCardByTools(
	    @RequestParam(name = "mediumId") Long mediumId,
	    @RequestParam(name = "formatId") Long formatId) {
	return service.getArtistCardByTools(mediumId, formatId);
    }

    public List<ArtistTop3> getArtistsOfTheMonth() {
	return null;
    }

}
