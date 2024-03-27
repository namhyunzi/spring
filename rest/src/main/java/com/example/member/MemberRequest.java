package com.example.member;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequest {
	
	@Schema(description = "이메일", example = "hyun@gmail.com")
	private String email;
	@Schema(description = "비밀번호", example = "영어대소문자 및 숫자")
	private String password;
	@Schema(description = "이름", example = "남현돌")
	private String name;
	@Schema(description = "전화번호", example = "010-1111-1111")
	private String tel;
	
	public Member toEntity() {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(password);
		member.setName(name);
		member.setTel(tel);
		member.setCreatedDate(LocalDateTime.now());
		
		return member;
	}
}
