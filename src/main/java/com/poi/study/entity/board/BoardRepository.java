package com.poi.study.entity.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.poi.study.dto.board.BoardRequestDto;

public interface BoardRepository extends JpaRepository <Board, Long>{

	String UPDATE_BOARD = "UPDATE Board"+
			"SET TITLE =:#{#boardRequestDto.title}, "+
			"CONTNET =:#{#boardRequestDto.content}, "+
			"UPDATE_TIME = NOW() "+
			"WHERE ID = :#{#boardRequestDto.id}";
	
	static final String UPDATE_BOARD_READ_CNT_INC = "UPDATE Board "
			+ "SET READ_CNT = READ_CNT + 1 "
			+ "WHERE ID = :id";
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD, nativeQuery = true)
	public int updateBoard(@Param("boardRequestDto") BoardRequestDto boardRequestDto);

	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD_READ_CNT_INC, nativeQuery = true)
	public int updateBoardReadCntInc(@Param("id") Long id);
}
