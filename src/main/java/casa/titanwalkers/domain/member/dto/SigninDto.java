package casa.titanwalkers.domain.member.dto;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record SigninDto(String email) {

    public static SigninDto of(String email) {
        return SigninDto.builder()
                .email(email)
                .build();
    }
}
