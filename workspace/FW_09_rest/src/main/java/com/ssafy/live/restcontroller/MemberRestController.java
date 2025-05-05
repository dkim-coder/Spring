package com.ssafy.live.restcontroller;

import com.ssafy.live.model.dto.Member;
import com.ssafy.live.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
@Slf4j
public class MemberRestController implements RestControllerHelper {
    private final MemberService mService;

    @PostMapping
    private ResponseEntity<?> registMember(@RequestBody Member member) {
        try {
            mService.registMember(member);
//            return Map.of("stats", "success", "member", member);
                return handleSuccess(member, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            e.printStackTrace();
//            return Map.of("stats", "fail", "error", e);
            return handleFail(e);
        }
    }

}
