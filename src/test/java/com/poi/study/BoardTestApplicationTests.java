package com.poi.study;
	
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poi.study.dto.board.BoardRequestDto;
import com.poi.study.dto.board.BoardResponseDto;
import com.poi.study.service.BoardService;

@SpringBootTest
class BoardTestApplicationTests {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	void save() {
		BoardRequestDto boardSaveDto = new BoardRequestDto();
		
		boardSaveDto.setTitle("제목입니다.");
		boardSaveDto.setContent("내용입니다.");
		boardSaveDto.setRegisterId("작성자");
		
		Long result = boardService.save(boardSaveDto);
		
		if(result >0) {
			System.out.println("# success save() ~");
			findAll();
			findById(result);
		}else {
			System.out.println("Fail Save() ~");
			
		}
	}
	
	void findAll() {
		List < BoardResponseDto > list = boardService.findAll();
		
		if(list != null) {
			System.out.println("# success findAll() : "+ list.toString());
		}else {
			System.out.println("# Fail findAll() ~");
		}
	}
	
	void findById(Long id) {
		BoardResponseDto info = boardService.findById(id);
		
		if(info != null) {
			System.out.println("# Success findById() :"+ info.toString());
		}else {
			System.out.println("# Fail findById() ~");
		}
	}
	
	void updateBoard(Long id) {
		
		BoardRequestDto boardRequestDto = new BoardRequestDto();
		
		boardRequestDto.setId(id);
		boardRequestDto.setTitle("업데이트 제목");
		boardRequestDto.setContent("업데이트 내용");
		boardRequestDto.setRegisterId("작성자");
		
		int result = boardService.updateBoard(boardRequestDto);
		
		if(result > 0) {
			System.out.println("# successs updateBoard() ~");
		} else {
			System.out.println("# Fail updateBoard() ~");
		}
	}
}
