package com.example.demo.model.service;

import lombok.*;
import com.example.demo.model.domain.Member;
import javax.validation.constraints.*;

@Getter
@Setter
public class AddMemberRequest {

    // 이름: 공백 및 특수문자 금지
    @NotBlank(message = "이름은 비어 있을 수 없습니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣]+$", message = "이름은 공백, 숫자 및 특수문자를 포함할 수 없습니다.")
    private String name;

    // 이메일: 공백 금지, 이메일 형식 체크
    @NotBlank(message = "이메일은 비어 있을 수 없습니다.")
    @Email(message = "유효하지 않은 이메일 형식입니다.")
    private String email;

    // 패스워드: 패턴 체크 (8자 이상, 대소문자, 숫자, 특수문자 포함)
    @NotBlank(message = "패스워드는 비어 있을 수 없습니다.")
    @Size(min = 8, message = "패스워드는 최소 8자 이상이어야 합니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]+$", 
             message = "패스워드는 대소문자, 숫자, 특수문자를 포함해야 합니다.")
    private String password;

    // 나이: 19세 이상, 90세 이하
    @NotNull(message = "나이는 필수 입력 값입니다.")
    @Min(value = 19, message = "나이는 19세 이상이어야 합니다.")
    @Max(value = 90, message = "나이는 90세 이하이어야 합니다.")
    private Integer age;

    // 모바일: 정해진 패턴 준수
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", 
             message = "모바일 번호는 '010-1234-5678' 형식이어야 합니다.")
    private String mobile;

    // 주소: 공백 허용
    private String address;

    // Member 객체로 변환하는 메서드
    public Member toEntity() {
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
