package com.lth.blog2.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lth.blog2.model.RoleType;
import com.lth.blog2.model.User;
import com.lth.blog2.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired  // 의존성 주입
	private UserRepository userRepository;
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();		
	}
	
	//  한페이지당 2건의 데이터를 리턴받음
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	
	// {id} 주소로 파라미터를 전달 받을 수 있음.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		// 람다식
		User user = userRepository.findById(id).orElseThrow(()-> {
			return new IllegalArgumentException("해당 유저는 없습니다." + id);
		});
		return user;
	}

	// http://localhost:8000/blog2/dummy/join
	@PostMapping("/dummy/join")
	public String join(User user) {
		
//		user.setUsername("hong");
//		user.setPassword("1234");
//		user.setEmail("hong@naver.com");
//		user.setRole(RoleType.USER);

		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
//		System.out.println("role : " + user.getRole());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다";
	}
}
