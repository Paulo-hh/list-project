package com.devsupeior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsupeior.dslist.entities.Game;
import com.devsupeior.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
				tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game, tb_belonging
			WHERE tb_game.id = tb_belonging.game_id and tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
			""")
	List<GameMinProjection> searchByList(Long listId); // representa um numero na consulta sql 
}
