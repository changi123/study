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
	private int example_id; // 예문아이디
	private int question_id; // 문제아이디
	private String example_detail; // 예문내용
	
}
