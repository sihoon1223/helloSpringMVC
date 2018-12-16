package kr.ac.hansung.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Offer {
	
//	@Size(min=2, max=100,message="name must be between 2 and 100 chars") // 최소 2 최대 100
//	private String name;
//	
//	@Email(message ="please provide a valid email adress") //잘못된 email이면 메시지
//	@NotEmpty(message="cannot be empty")// 비어있으면 메시지
//	private String email;
//	
//	@Size(min=5, max=100, message="Text must be between 5 100chars") // 5~100
//	private String text;

	
	@Size(min=2010, max=2020, message="year must be between 2010 and 2020 integer")
	private int year; //수강년도
	
	@Size(min=1, max=2, message="semester must be between 1 and 2 integer")
	private int semester; //학기

	@Size(min=5, max=10, message="code must be between 5 and 10 chars")
	private String code; //과목 코드

	@NotNull
	private String name; //과목 이름
	
	@Size(min=2, max=5, message="type must be between 2 and 5 chars")
	private String type; //전선,전지등 타입!
	
	@Size(min=1, max=3, message="grade must be between 1 and 3 integer")
	private int point;
}