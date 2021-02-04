package kr.pe.controller.swaggestudy.api.v1;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "SwaggerControllerV1 V1")  //SwaggerControllerV1 을 대표하는 최상단 타이틀 영역에 표시될 값
@RequestMapping("/v1/api")
public class SwaggerControllerV1 {

	//각각의 리소스에 제목과 설명 표기
    @ApiOperation(value = "exam", notes = "예제입니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @GetMapping(value = "/board")
    public Map<String, String> selectOneBoard(@ApiParam(value = "게시판번호", required = true, example = "1") @RequestParam String no) {
        Map<String, String> result = new HashMap<>();
        result.put("author", "김혜경");
        result.put("content", "API V1 문서입니다.");
        return result;
    }
}