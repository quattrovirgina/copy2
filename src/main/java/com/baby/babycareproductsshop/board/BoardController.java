package com.baby.babycareproductsshop.board;

import com.baby.babycareproductsshop.board.model.*;
import com.baby.babycareproductsshop.common.PageNation;
import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.common.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    // 게시판 목록 출력
    @GetMapping
    public List<BoardGetVo> getBoard(@RequestParam(name = "board_code") int boardCode, @RequestParam(name = "page") int page) throws Exception {
        try {
            if (Utils.isNotNull(boardCode) && Utils.isNotNull(page)) {
                PageNation.Criteria criteria = new PageNation.Criteria();
                criteria.setPage(page);
                criteria.setBoardCode(boardCode);
                List<BoardGetVo> list = service.getBoard(criteria);
//        PageNation pageNation = new PageNation(criteria, list.size());
                return list;
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    // 게시글 읽기
    @GetMapping("/{iboard}")
    public BoardSelVo selBoard(@PathVariable int iboard) throws Exception {
        try {
            if (Utils.isNotNull(iboard)) {
                return service.selBoard(iboard);
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    // 게시글 등록
    @PostMapping
    public ResVo insBoard(@RequestPart BoardInsDto dto, @RequestPart List<MultipartFile> pics) {
        try {
            if (Utils.isNotNull(dto) && Utils.isNotNull(pics)) {
                dto.setPics(pics);
                return service.insBoard(dto);
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            // 추후 예외 처리 추가
            return null;
        }
    }

    // 게시글 수정
    @PatchMapping
    public ResVo updBoard(@RequestPart BoardUpdDto dto, @RequestPart List<MultipartFile> pics) {
        try {
            if (Utils.isNotNull(dto) && Utils.isNotNull(pics)) {
                dto.setPics(pics);
                return service.updBoard(dto);
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            // 추후 예외 처리 추가
            return null;
        }
    }

    // 게시글 삭제
    @DeleteMapping("{iboard}")
    public ResVo delBoard(@PathVariable int iboard) {
        try {
            if (Utils.isNotNull(iboard)) {
                return service.delBoard(iboard);
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            // 추후 예외 처리 추가
            return null;
        }
    }
}
