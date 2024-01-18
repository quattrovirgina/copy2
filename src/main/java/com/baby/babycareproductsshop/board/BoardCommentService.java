package com.baby.babycareproductsshop.board;

import com.baby.babycareproductsshop.board.model.*;
import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.common.Utils;
import com.baby.babycareproductsshop.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.baby.babycareproductsshop.common.Const.FAIL;
import static com.baby.babycareproductsshop.common.Const.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardCommentService {
    private final BoardCommentMapper mapper;
    private final AuthenticationFacade authenticationFacade;


    public List<BoardCommentGetVo> getComment(int iboard) {
        try {
            List<BoardCommentGetVo> list = mapper.getComment(iboard);

            if (Utils.isNotNull(list)) {
                return list;
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

    public ResVo insComment(BoardCommentInsDto dto) {
        try {
            int insCommentRows = mapper.insComment(dto);

            if (Utils.isNotNull(insCommentRows)) {
                return new ResVo(SUCCESS);
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

    public ResVo delComment(int icomment) {
        try {
            int delCommentRows = mapper.delComment(icomment);

            if (Utils.isNotNull(delCommentRows)) {
                return new ResVo(SUCCESS);
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

    public ResVo updComment(BoardCommentUpdDto dto) {
        int updCommentRows = mapper.updComment(dto);

        try {
            if (Utils.isNotNull(updCommentRows)) {
                return new ResVo(SUCCESS);
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