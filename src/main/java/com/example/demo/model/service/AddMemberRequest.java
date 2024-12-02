package com.example.demo.model.service;

import lombok.*; // 어노테이션 자동 생성
import com.example.demo.model.domain.Member;
import javax.validation.constraints.*; // Bean Validation 어노테이션 추가
import javax.validation.constraints.Pattern; // 올바른 패턴 어노테이션 임포트

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Data // getter, setter, toString, equals 등 자동 생성
public class AddMemberRequest {

    // 이름: 공백 및 특수문자 금지
    @NotBlank(message = "이름은 비어 있을 수 없습니다.") // 공백 금지
    @Pattern(regexp = "^[a-zA-Z가-힣]+$", message = "이름은 공백, 숫자 및 특수문자를 포함할 수 없습니다.") // 특수문자 및 숫자 금지
    private String name;

    // 이메일: 공백 금지, 이메일 형식 체크
    @NotBlank(message = "이메일은 비어 있을 수 없습니다.") // 공백 금지
    @Email(message = "이메일 형식이 올바르지 않습니다.") // 이메일 형식 체크
    private String email;

    // 패스워드: 패턴 체크 (8자 이상, 대소문자 포함)
    @NotBlank(message = "패스워드는 비어 있을 수 없습니다.") // 공백 금지
    @Size(min = 8, message = "패스워드는 최소 8자 이상이어야 합니다.") // 최소 8자
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).+", message = "패스워드는 대소문자를 포함해야 합니다.") // 대소문자 포함
    private String password;

    // 나이: 19세 이상, 90세 이하
    @NotBlank(message = "나이는 비어 있을 수 없습니다.") // 공백 금지
    @Min(value = 19, message = "나이는 19세 이상이어야 합니다.") // 최소 19세
    @Max(value = 90, message = "나이는 90세 이하이어야 합니다.") // 최대 90세
    private String age;

    // 모바일: 공백 허용
    private String mobile; // 공백 허용

    // 주소: 공백 허용
    private String address; // 공백 허용

    // Member 객체로 변환하는 메서드
    public Member toEntity(){ // Member 생성자를 통해 객체 생성
        return Member.builder()
            .name(name)
            .email(email)
            .password(password)
            .age(age)
            .mobile(mobile)
            .address(address)
            .build();
    }
}
