package com.myanimelist.MyAnimeList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.myanimelist.MyAnimeList.Model.Anime;
import com.myanimelist.MyAnimeList.repository.AnimeRepo;

@Component
public class AnimeCrudService {
	
	@Autowired
	AnimeRepo repo;

	public Anime saveAnime(Anime anime) {
		return repo.save(anime);
	}
	
	public List<Anime> getAllAnime(){
		List<Anime> findAll = (List<Anime>)repo.findAll();
		return findAll;
	}
	
	public List<Anime> getAllAnimeRatingBased(){
		List<Anime> findAll = (List<Anime>)repo.findAllByOrderByScoreDesc();
		return findAll;
	}
	
	public List<Anime> getAnimeByName(String title){
		List<Anime> findAll = (List<Anime>)repo.findByTitleContainingIgnoreCase(title);
		return findAll;
	}
	
	public List<Anime> getAnimeByGenre(String genre){
		List<Anime> findAll = (List<Anime>)repo.findByGenreIgnoreCase(genre);
		return findAll;
	}
	
	
	public String deleteAnime(String anime) {
		int val = repo.deleteByTitleIgnoreCase(anime);
		if(val > 0) {
			return anime+" deleted from your anime list";
		}
		else {
			return anime+" not found";
		}
	}
}
