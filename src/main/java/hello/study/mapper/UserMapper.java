package hello.study.mapper;

import hello.study.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // userId로 사용자 조회 
    UserDto findByUserId(String userId);

    // 유저 회원가입
	int insertUser(UserDto userDto);
	
}
