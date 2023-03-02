package com.poi.study.entity.board;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public class BoardRepository extends JpaRepository <Board, Long>{

	String UPDATE_BOARD = "UPDATE Board"+
	"SET TITLE =:#{#boardRequestDto.title}, "+
	"CONTNET =:#{#boardRequestDto.content}, "+
	"UPDATE_TIME = NOW() "+
	"WHERE ID = :#{#boardRequestDto.id}";
	
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD, nativeQuery = true)
	public int updateBoard(@Param("boardRequestDto") BoardRequestDto boardRequestDto)
}
