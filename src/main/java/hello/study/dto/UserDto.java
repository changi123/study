package hello.study.dto;

import java.time.LocalDateTime;

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
public class UserDto {
    private String userId;         // 유저아이디
    private String password;        // 유저패스워드
    private String email;           // 유저이메일
    private String role;            // 권한
    private LocalDateTime createdAt; // 생성일
    private LocalDateTime updatedAt; // 수정일
}
