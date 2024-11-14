package com.devsupeior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsupeior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	
}
