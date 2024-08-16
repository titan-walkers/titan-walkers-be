package casa.titanwalkers.controller.member;

import casa.titanwalkers.domain.member.dto.SigninRequest;
import casa.titanwalkers.service.member.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/member")
@Tag(name = "member", description = "유저 정보")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(description = "로그인")
    @PostMapping("signin")
    public ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(memberService.signin(signinRequest));
    }

    @DeleteMapping("signout")
    public ResponseEntity<?> signout() {
        return ResponseEntity.ok().build();
    }
}
