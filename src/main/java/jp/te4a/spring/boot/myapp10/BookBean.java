package jp.te4a.spring.boot.myapp10;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean{
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String title;
	private String writer;
	private String publisher;
	private Integer price;
}