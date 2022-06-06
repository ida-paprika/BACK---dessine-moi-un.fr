package co.simplon.p25.dessinemoiun.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.p25.dessinemoiun.dtos.ArtMediumView;
import co.simplon.p25.dessinemoiun.services.ArtMediumService;

@RestController
@RequestMapping("artmediums")
public class ArtMediumController {

    private final ArtMediumService service;

    public ArtMediumController(ArtMediumService service) {
	this.service = service;
    }

    @GetMapping
    public List<ArtMediumView> getAllMediums() {
	return service.getAllMediums();
    }

    // TODO endpoint to get one artist mediums

}
