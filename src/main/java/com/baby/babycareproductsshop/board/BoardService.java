package com.baby.babycareproductsshop.board;

import com.baby.babycareproductsshop.board.model.*;
import com.baby.babycareproductsshop.common.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.baby.babycareproductsshop.common.Const.FAIL;
import static com.baby.babycareproductsshop.common.Const.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;
    private final MyFileUtils myFileUtils;

    public BoardPicsDto createPics(int iboard, List<MultipartFile> pics) {
        try {
            BoardPicsDto dto = new BoardPicsDto();
            dto.setIboard(iboard);
            dto.setPics(pics);
            String path = "/board/" + dto.getIboard();
            List<String> fileNameList = dto.getPicNames();

            myFileUtils.delDirTrigger(path);

            for (MultipartFile pic : dto.getPics()) {
                String savedFileName = myFileUtils.transferTo(pic, path);
                fileNameList.add(savedFileName);
            }

            return dto;
        } catch (Exception e) {
            // 추후 예외 처리 추가
            return null;
        }
    }

    public ResVo insBoard(BoardInsDto dto) {
        try {
            int insBoardRows = mapper.insBoard(dto); // 게시글 사진 등록

            if (Utils.isNotNull(insBoardRows)) {
                BoardPicsDto picsDto = createPics(dto.getIboard(), dto.getPics());
                int insBoardPicsRows = mapper.insBoardPics(picsDto);

                if (dto.getPics().size() == insBoardPicsRows) {
                    return new ResVo(SUCCESS);
                } else {
                    // 추후 예외 처리
                    return null;
                }
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            // 추후 예외 처리 추가
            return null;
        }
    }

    public ResVo updBoard(BoardUpdDto dto) {
        try {
            int updBoardRows = mapper.updBoard(dto);

            if (Utils.isNotNull(updBoardRows)) {
                BoardPicsDto picsDto = createPics(dto.getIboard(), dto.getPics());
                int insBoardPicsRows = mapper.insBoardPics(picsDto);

                if (dto.getPics().size() == insBoardPicsRows) {
                    return new ResVo(SUCCESS);
                } else {
                    // 추후 예외 처리 추가
                    return null;
                }
            } else {
                // 추후 예외 처리 추가
                return null;
            }
        } catch (Exception e) {
            return new ResVo(FAIL);
        }
    }

    public ResVo delBoard(int iboard) {
        try {
            int delBoardRows = mapper.delBoard(iboard);

            if (Utils.isNotNull(delBoardRows)) {
                String path = "/board/" + iboard;
                myFileUtils.delDirTrigger(path);
                return new ResVo(SUCCESS);
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

    public BoardSelVo selBoard(int iboard) {
        return mapper.selBoard(iboard);
    }

    public List<BoardGetVo> getBoard(PageNation.Criteria criteria) {
        return mapper.getBoard(criteria);
    }

    public List<BoardCommentGetDto> getComment(int iboard) {
        return mapper.getComment(iboard);
    }

    public ResVo insComment(BoardCommentInsDto dto) {
        return new ResVo(Utils.isNotNull(mapper.insComment(dto)) ? SUCCESS : FAIL);
    }

    public ResVo delComment(int icomment) {
        return new ResVo(Utils.isNotNull(mapper.delComment(icomment)) ? SUCCESS : FAIL);
    }

    public ResVo updComment(BoardCommentUpdDto dto) {
        return new ResVo(Utils.isNotNull(mapper.updComment(dto)) ? SUCCESS : FAIL);
    }
}