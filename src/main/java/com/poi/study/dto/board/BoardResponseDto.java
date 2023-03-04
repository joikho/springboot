package com.poi.study.dto.board;

import java.time.LocalDateTime;

import com.poi.study.entity.board.Board;

import lombok.Getter;

@Getter
public class BoardResponseDto {
	private Long id;
	private	String	title;
	private String	content;
	private int readCnt;
	private String registerId;
	private LocalDateTime registerTime;
	
	public BoardResponseDto(Board entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.readCnt = entity.getReadCnt();
		this.registerId = entity.getRegisterId();
		this.registerTime = entity.getRegisterTime();
	}

	@Override
	public String toString() {
		return "BoardResponseDto [id=" + id + ", title=" + title + ", content=" + content + ", readCnt=" + readCnt
				+ ", registerId=" + registerId + ", registerTime=" + registerTime + "]";
	}
	
	
}
		