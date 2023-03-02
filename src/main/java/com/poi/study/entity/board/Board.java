package com.poi.study.entity.board;

import com.poi.study.entity.BaseTimeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Board extends BaseTimeEntity{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String title;
		private String content;
		private int readCnt;
		private String registerId;
		
		@Builder
		public Board(Long id, String title, String content, int readCnt, String registerId) {
			this.id	= id;
			this.title = title;
			this.content = content;
			this.readCnt = readCnt;
			this.registerId = registerId;
			
		}

		/* */		
}
