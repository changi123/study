package hello.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hello.study.dto.UserDto;
import hello.study.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public int insertUser(UserDto userDto) {
		
		String userId = userDto.getUserId();
		String password = userDto.getPassword();
	    // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(password);
        
        userDto.setPassword(encryptedPassword);
		return userMapper.insertUser(userDto);
		
	}
	
	
	

	
//	// 단어 아이디별 정보 조회 
//	public QuestionDto selectByQuestionId(int questionId) {
//		return wordMapper.selectByQuestionId(questionId);
//		
//	} 
	









	
}
