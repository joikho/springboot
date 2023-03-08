package com.poi.study.service;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poi.study.dto.board.BoardRequestDto;
import com.poi.study.dto.board.BoardResponseDto;
import com.poi.study.entity.board.Board;
import com.poi.study.entity.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Transactional
	public Long save(BoardRequestDto boardSaveDto) {
		return boardRepository.save(boardSaveDto.toEntity()).getId();
	}
	/*
	 *  트랜잭션에 readOnly=true 옵션을 주면 스프링 프레임워크가 하이버네이트 세션 플러시 모드를 
	 *  MANUAL로 설정한다.
	 *  이렇게 하면 강제로 플러시를 호출하지 않는 한 플러시가 일어나지 않는다.
	 *	따라서 트랜잭션을 커밋하더라도 영속성 컨텍스트라 플러시 되지 않아서 엔티티의 등록, 수정, 삭제가 동작하지 않고,
	 *  또한 읽기 전용으로, 영속성 컨텍스트는 변경 감지를 위한 스냅샷을 보관하지 않으므로 성능이 향상된다.
	 */
	@Transactional(readOnly = true)
	public HashMap< String, Object> findAll(Integer page, Integer size){
		
		HashMap <String, Object> resultMap = new HashMap<String, Object>();
		Page < Board > list = boardRepository.findAll(PageRequest.of(page, size));
		
		resultMap.put("list", list.stream().map(BoardResponseDto::new).collect(Collectors.toList()));
		resultMap.put("paging",list.getPageable());
		resultMap.put("totalCnt",list.getTotalElements());
		resultMap.put("totalPage",list.getTotalPages());
		
		System.out.println("list : "+list.stream().map(BoardResponseDto::new).collect(Collectors.toList()));
		System.out.println("paging :"+list.getPageable());
		System.out.println("totalCnt : "+list.getTotalElements());
		System.out.println("totalPage : "+list.getTotalPages());
		return resultMap;
		
	}
	
	public BoardResponseDto findById(Long id) {
		boardRepository.updateBoardReadCntInc(id);
		return new BoardResponseDto(boardRepository.findById(id).get());
	}
	
	public int updateBoard(BoardRequestDto boardRequstDto) {
		return boardRepository.updateBoard(boardRequstDto);
	}
	
	public int updateBoardReadCntInc(Long id) {
		return boardRepository.updateBoardReadCntInc(id);
	}
	
	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}
	
	public void deleteAll(Long[] deleteId) {
		boardRepository.deleteBoard(deleteId);
	}
}
