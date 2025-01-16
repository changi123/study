package hello.study.service;

import hello.study.dto.UserDto;
import hello.study.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // userId로 DB에서 사용자 정보 조회
        UserDto userDto = userMapper.findByUserId(userId);

        if (userDto == null) {
            throw new UsernameNotFoundException("User not found with username: " + userId);
        }

        // 사용자 정보로 UserDetails 객체 생성
        return new User(
            userDto.getUserId(),  // userId를 username으로 사용
            userDto.getPassword(), // 암호화된 패스워드
            Collections.singletonList(new SimpleGrantedAuthority(userDto.getRole())) // 권한 정보
        );
    }
}