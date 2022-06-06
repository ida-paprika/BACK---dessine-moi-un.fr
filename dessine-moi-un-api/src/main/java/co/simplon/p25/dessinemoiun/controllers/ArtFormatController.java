package co.simplon.p25.dessinemoiun.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.p25.dessinemoiun.dtos.ArtFormatView;
import co.simplon.p25.dessinemoiun.services.ArtFormatService;

@RestController
@RequestMapping("artformats")
public class ArtFormatController {

    private final ArtFormatService service;

    public ArtFormatController(ArtFormatService service) {
	this.service = service;
    }

    @GetMapping
    public List<ArtFormatView> getAllFormats() {
	return service.getAllFormats();
    }

}
