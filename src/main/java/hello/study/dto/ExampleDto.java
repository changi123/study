package hello.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDto {
	private int exampleId; // 예문아이디
	private int questionId; // 문제아이디
	private String exampleDetail; // 예문내용
	
}
