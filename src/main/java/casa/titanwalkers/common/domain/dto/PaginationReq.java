package casa.titanwalkers.common.domain.dto;

import com.querydsl.core.types.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record PaginationReq(
        @Schema(description = "페이지 넘버")
        Integer number,
        @Schema(description = "페이지 사이즈")
        Integer size,
        @Schema(description = "정렬 키워드")
        String sort,
        @Schema(description = "정렬 형식")
        @Enumerated(EnumType.STRING)
        Order order
) {
}
