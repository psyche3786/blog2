package com.lth.blog2.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String title;
	
	// 섬머노트 라이브러리 <html>태그가 섞여서 디자인이됨.
	@Lob //  대용량 데이터때 사용
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne // Many = 게시글, User = 사용자
	@JoinColumn(name = "userId")
	private User user; // DB는 오브젝트를 저장할 수 없다.
	
	@CreationTimestamp
	private Timestamp createDate;	
}
