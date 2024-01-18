package com.baby.babycareproductsshop.board;

import com.baby.babycareproductsshop.board.model.BoardCommentGetVo;
import com.baby.babycareproductsshop.board.model.BoardCommentInsDto;
import com.baby.babycareproductsshop.board.model.BoardCommentUpdDto;
import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.common.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Tag(name = "게시판 댓글 API", description = "게시판 댓글 관련 파트")
public class BoardCommentController {
    private final BoardCommentService service;

    @GetMapping
    @Operation(summary = "댓글 목록 출력 기능", description = "")
    public List<BoardCommentGetVo> getComment(int iboard) {
        try {
            List<BoardCommentGetVo> list = service.getComment(iboard);

            if (Utils.isNotNull(list)) {
                return list;
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 추후 예외 처리 추가
            return null;
        }
    }

    @PostMapping
    @Operation(summary = "댓글 등록 기능", description = "")
    public ResVo insComment(BoardCommentInsDto dto) {
        try {
            if (Utils.isNotNull(dto)) {
                return service.insComment(dto);
            } else {
                // 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            // 추후 예외 처리 추가
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping
    @Operation(summary = "댓글 삭제 기능", description = "")
    public ResVo delComment(int icomment) {
        try {
            if (Utils.isNotNull(icomment)) {
                return service.delComment(icomment);
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            // 추후 예외 처리 추가
            e.printStackTrace();
            return null;
        }
    }

    @PatchMapping
    @Operation(summary = "댓글 수정 기능", description = "")
    public ResVo updComment(BoardCommentUpdDto dto) {
        try {
            if (Utils.isNotNull(dto)) {
                return service.updComment(dto);
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            // 추후 예외 처리 추가
            e.printStackTrace();
            return null;
        }
    }
}
