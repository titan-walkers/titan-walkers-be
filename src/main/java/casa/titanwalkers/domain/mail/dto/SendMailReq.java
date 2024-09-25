package casa.titanwalkers.domain.mail.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record SendMailReq(
        @Schema(description = "보내는 사람 이메일", example = "abc@titanworks.co")
        String receiverEmail,
        @Schema(description = "받는 사람 이메일", example = "abc@titanworks.co")
        String senderEmail,
        @Schema(description = "제목", example = "제목입니다.")
        String title,
        @Schema(description = "내용", example = "내용입니다.")
        String content,
        @Schema(description = "개별 전송 여부", example = "true")
        Boolean isIndividual
) {
}
