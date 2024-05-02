package com.myanimelist.MyAnimeList.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myanimelist.MyAnimeList.Model.Anime;

@Repository
public interface AnimeRepo extends CrudRepository<Anime, Long> {

	List<Anime> findAllByOrderByScoreDesc();
	
	List<Anime> findByTitleContainingIgnoreCase(String title);
	
	List<Anime> findByGenreIgnoreCase(String genre);
	
	int deleteByTitleIgnoreCase(String title);
}
