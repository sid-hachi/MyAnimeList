package com.myanimelist.MyAnimeList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myanimelist.MyAnimeList.Model.Anime;
import com.myanimelist.MyAnimeList.service.AnimeCrudService;


@RestController
@RequestMapping("/anime")
public class AnimeController {
	
	@Autowired
	AnimeCrudService service;
	
	@PostMapping("/saveanime")
	public Anime saveAnime(@RequestBody Anime anime) {
		System.out.println(">>>>>>>>>>>>"+anime.getTitle());
		return service.saveAnime(anime);
	}
	
	@GetMapping("/allanime")
	public List<Anime> getAllAnimes(){
		return service.getAllAnime();
	}
	@GetMapping("/byscore")
	public List<Anime> getAllAnimesByScore(){
		return service.getAllAnimeRatingBased();
	}
	
	@GetMapping("/byname")
	public List<Anime> getAllAnimesByName(@RequestParam String title){
		return service.getAnimeByName(title);
	}
	
	@GetMapping("/bygenre")
	public List<Anime> getAllAnimesByGenre(@RequestParam String genre){
		return service.getAnimeByGenre(genre);
	}
	
	@DeleteMapping("/bytitle")
	public String deleteAnimeByTitle(@RequestParam String title){
		return service.deleteAnime(title);
	}

}
