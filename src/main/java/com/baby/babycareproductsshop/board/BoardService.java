package com.baby.babycareproductsshop.board;

import com.baby.babycareproductsshop.board.model.*;
import com.baby.babycareproductsshop.common.*;
import com.baby.babycareproductsshop.exception.AuthErrorCode;
import com.baby.babycareproductsshop.exception.RestApiException;
import com.baby.babycareproductsshop.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final AuthenticationFacade authenticationFacade;

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
            throw new RestApiException(AuthErrorCode.PICS_CREATE_FAIL);
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
                    // 테이블에 게시글 등록은 됐으나 사진 저장이 제대로 이루어지지 않았을 경우 다 삭제
                    mapper.delBoard(dto.getIboard());
                    String path = "/board/" + dto.getIboard();
                    myFileUtils.delDirTrigger(path);
                    throw new RestApiException(AuthErrorCode.POST_REGISTER_FAIL);
                }
            } else {
                throw new RestApiException(AuthErrorCode.POST_REGISTER_FAIL);
            }
        } catch (Exception e) {
            throw new RestApiException(AuthErrorCode.GLOBAL_EXCEPTION);
        }
    }

    public ResVo updBoard(BoardUpdDto dto) {
        try {
            int updBoardRows = mapper.updBoard(dto);
            int loginUserPk = authenticationFacade.getLoginUserPk();
            log.info("loginUserPk = {}", loginUserPk);

            if (Utils.isNotNull(updBoardRows)) {
                BoardPicsDto picsDto = createPics(dto.getIboard(), dto.getPics());
                int insBoardPicsRows = mapper.insBoardPics(picsDto);

                if (dto.getPics().size() == insBoardPicsRows) {
                    return new ResVo(SUCCESS);
                } else {
                    // >>>>> (추후 수정) 테이블에 게시글 수정은 됐으나 사진 업로드(수정)가 제대로 이루어지지 않았을 때
                    throw new RestApiException(AuthErrorCode.POST_REGISTER_FAIL);
                }
            } else {
                throw new RestApiException(AuthErrorCode.POST_REGISTER_FAIL);
            }
        } catch (Exception e) {
            throw new RestApiException(AuthErrorCode.GLOBAL_EXCEPTION);
        }
    }

    public ResVo delBoard(int iboard) {
        try {
            int delBoardRows = mapper.delBoard(iboard);
            int loginUserPk = authenticationFacade.getLoginUserPk();
            log.info("loginUserPk = {}", loginUserPk);

            if (Utils.isNotNull(delBoardRows)) {
                String path = "/board/" + iboard;
                myFileUtils.delDirTrigger(path);
                return new ResVo(SUCCESS);
            } else {
                // >>>>> (추후 수정) 테이블에 게시글 삭제는 됐으나 사진 삭제가 제대로 이루어지지 않았을 때
                throw new RestApiException(AuthErrorCode.POST_DELETE_FAIL);
            }
        } catch (Exception e) {
            throw new RestApiException(AuthErrorCode.GLOBAL_EXCEPTION);
        }
    }

    public BoardSelVo selBoard(int iboard) {
        try {
            BoardSelVo vo = mapper.selBoard(iboard);

            if (Utils.isNotNull(vo)) {
                return vo;
            } else {
                throw new RestApiException(AuthErrorCode.POST_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new RestApiException(AuthErrorCode.GLOBAL_EXCEPTION);
        }
    }

    public List<BoardGetVo> getBoard(PageNation.Criteria criteria) {
        try {
            List<BoardGetVo> list = mapper.getBoard(criteria);

            if (Utils.isNotNull(list)) {
                return list;
            } else {
                throw new RestApiException(AuthErrorCode.POST_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new RestApiException(AuthErrorCode.GLOBAL_EXCEPTION);
        }
    }
}