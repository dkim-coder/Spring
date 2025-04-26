package com.ssafy.controller;

import com.ssafy.model.dto.user.User;
import com.ssafy.model.service.user.IUserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService;

    // 로그아웃
    @GetMapping("/auth/logout")
    private String handleLogout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/index";
    }

    // 이메일로 아이디 찾기
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> findIdByEmail(@RequestParam String email) {
        try {
            String userId = userService.findIdByEmail(email);
            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // 사용자 번호 조회
    @GetMapping("/{userId}/number")
    @ResponseBody
    public ResponseEntity<Long> getUserNumber(@PathVariable String userId) {
        try {
            Long userNumber = userService.findNoById(userId);
            return ResponseEntity.ok(userNumber);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 사용자 정보 조회
    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<User> getUserInfo(@PathVariable Long userId) {
        try {
            User user = userService.findByNo(userId);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //로그인
    @PostMapping("/login")
    public String handleLogin(@RequestParam String id,
                              @RequestParam String password,
                              HttpSession session,
                              Model model) {
        try {
            Long userNo = userService.findNoById(id);
            User user = userService.findByNo(userNo);

            if (user != null && userService.checkPassword(user.getPassword(), password)) {
                session.setAttribute("user", user);
                return "redirect:/index";  // 로그인 성공 시 메인 페이지로 이동
            } else {
                model.addAttribute("error", "잘못된 아이디 또는 비밀번호입니다.");
                return "login";  // 로그인 실패 시 로그인 페이지로 다시 이동 (에러 메시지 포함)
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "서버 오류가 발생했습니다: " + e.getMessage());
            return "login";  // 예외 발생 시 로그인 페이지로 이동
        }
    }

    //회원가입
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> handleRegister(
            @RequestBody(required = false) User jsonUser,
            @RequestParam(required = false) Map<String, String> formData) {

        User user = new User();

        // JSON 요청 처리
        if (jsonUser != null) {
            user = jsonUser;
        }
        // Form-data 요청 처리
        else if (formData != null && !formData.isEmpty()) {
            user.setId(formData.get("id"));
            user.setPassword(formData.get("password"));
            user.setUser_name(formData.get("user_name"));
            user.setEmail(formData.get("email"));
            user.setNickname(formData.get("nickname"));
        }

        // 이메일 필수 체크
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("이메일은 필수 입력 항목입니다.");
        }

        try {
            int result = userService.insert(user);
            if (result == 1) {
                return ResponseEntity.ok(user.getNo());
            } else {
                return ResponseEntity.badRequest().body("회원 가입 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("서버 오류: " + e.getMessage());
        }
    }

    //삭제
    @DeleteMapping("/users/{no}")
    @ResponseBody
    public ResponseEntity<?> deleteUser(@PathVariable Long no) {
        try {
            userService.delete(no);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("삭제 중 오류 발생: " + e.getMessage());
        }
    }

    //수정
    @PutMapping("/users/{no}/{action}")
    @ResponseBody
    public ResponseEntity<?> updateUserField(
            @PathVariable Long no,
            @PathVariable String action,
            @RequestBody User user) {
        user.setNo(no);
        boolean result;

        try {
            switch (action) {
                case "password":
                    result = userService.updatePassword(user);
                    break;
                case "nickname":
                    result = userService.updateNickname(user);
                    break;
                case "image":
                    result = userService.updateImage(user);
                    break;
                default:
                    return ResponseEntity.badRequest().body("잘못된 요청입니다.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("오류: " + e.getMessage());
        }
    }

}
