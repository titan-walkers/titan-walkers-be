package casa.titanwalkers.common.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationRes<T> {
    @Schema(description = "페이지 넘버", example = "1")
    private Integer number;

    @Schema(description = "페이지 사이즈", example = "10")
    private Integer size;

    @Schema(description = "총 페이지 수", example = "10")
    private Integer totalPage;

    @Schema(description = "총 데이터 수", example = "100")
    private Long totalElements;

    @Schema(description = "데이터")
    private List<T> data;
}
