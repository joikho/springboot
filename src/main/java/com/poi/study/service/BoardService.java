package com.poi.study.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poi.study.dto.board.BoardResponseDto;
import com.poi.study.entity.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Transactional
	public Long save(BoardRequstDto boardSaveDto) {
		return BoardRepository.save(boardSaveDto.toEntity()).getId();
	}
	
	@Transactional
	public List< BoardResponseDto> findAll(){
		return boardRepository.findAll().stream().map(BoardResponseDto::new).collect(Collectors.toList());
	}
	
	public BoardResponseDto findById(Long id) {
		return new BoardResponseDto(boardRepository.findById(id).get());
	}
	
	public int updateBoard(BoardRequestDto boardRequstDto) {
		return boardRepository.updateBoard(boardRequstDto);
	}
	
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}
}
