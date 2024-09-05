package casa.titanwalkers.domain.mail.dto.unit;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;

public record ReceivedMail(
        @Schema(description = "발신자 이메일", example = "test@tatian.casa")
        String email,
        @Schema(description = "제목", example = "title")
        String title,
        @Schema(description = "읽음 표시", example = "true")
        Boolean isRead,
        @Schema(description = "중요 표시", example = "true")
        Boolean starred,
        @Schema(description = "받은 날짜", example = "2024-08-08T13:39:56Z")
        ZonedDateTime createdAt
) {
}
