package hello.study.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@GetMapping("/")
	public String wordAddPage(HttpSession session) {
	       // 세션에서 방문 횟수 가져오기
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        // 방문 횟수가 없으면 0으로 초기화
        if (visitCount == null) {
            visitCount = 0;
        }

        // 방문 횟수 증가
        visitCount++;

        // 세션에 새로운 방문 횟수 저장
        session.setAttribute("visitCount", visitCount);

        // 로그 남기기
        log.info("방문횟수: {} | 방문 시간: {}", visitCount, LocalDateTime.now());

        return "index"; 
	}

	
}
