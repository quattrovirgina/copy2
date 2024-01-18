package com.baby.babycareproductsshop.review;

import com.baby.babycareproductsshop.common.Const;
import com.baby.babycareproductsshop.common.MyFileUtils;
import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.exception.AuthErrorCode;
import com.baby.babycareproductsshop.exception.CommonErrorCode;
import com.baby.babycareproductsshop.exception.RestApiException;
import com.baby.babycareproductsshop.review.model.*;
import com.baby.babycareproductsshop.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper mapper;
    private final MyFileUtils myFileUtils;
    private final AuthenticationFacade authenticationFacade;

    public ResVo insReview(ReviewInsDto dto) {
        //
        dto.setIuser(authenticationFacade.getLoginUserPk());
        log.info("dto = {}",dto);
        ReviewPicsInsDto insDto = new ReviewPicsInsDto();
        insDto.setIreview(dto.getIreview());
        log.info("insDto = {}",insDto);
        String target = "review/" + dto.getIreview();
        if (dto.getPics().size() > 6) {
            if (dto.getProductScore() < 1 || dto.getContents() == null || dto.getContents().equals("")) {
                throw new RestApiException(AuthErrorCode.REVIEW_NOT_PRODUCT_SCORE_OR_CONTENTS);
            }
            throw new RestApiException(AuthErrorCode.UPLOAD_PIC_NOT_REVIEW);
        }
        else if (dto.getPics().size() <= 5 && dto.getProductScore() > 1) {
            for (MultipartFile file : dto.getPics()) {
               String saveFileNm = myFileUtils.transferTo(file, target);
               insDto.getPics().add(saveFileNm);
            }
            throw new RestApiException(AuthErrorCode.UPLOAD_REVIEW_REGISTRATION_REVIEW);
        }
        int insReview = mapper.insReview(dto);
        int insPics = mapper.insReviewPics(insDto);
        return new ResVo(Const.SUCCESS);
    }

    public List<ReviewSelVo> getReview(ReviewSelDto dto){
        //
        dto.setIuser(authenticationFacade.getLoginUserPk());
        log.info("dto = {}",dto);
        List<ReviewSelVo> reviewSelVoList = mapper.getReview(dto);
        List<Integer> iReviewList = new ArrayList<>();
        Map<Integer, ReviewSelVo> reviewMap = new HashMap<>();
        for(ReviewSelVo vo : reviewSelVoList){
            iReviewList.add(vo.getIreview());
            reviewMap.put(vo.getIreview(), vo);
        }
        //
        if(iReviewList.size() > 0){
            //
            List<ReviewPicsVo> reviewPicsVoList = mapper.getReviewPics(iReviewList);
            for( ReviewPicsVo vo : reviewPicsVoList){
                ReviewSelVo reviewSelVo = reviewMap.get(vo.getIreview());
                List<String> pics = reviewSelVo.getPics();
                pics.add(vo.getReviewPic());
            }
        }
        return reviewSelVoList;

    }

    public ResVo delReview(ReviewDelDto dto) {
        //
        dto.setIuser(authenticationFacade.getLoginUserPk());
        log.info("dto = {}",dto);
        int selReview = mapper.selReviewByReview(dto);
        if( selReview == 0){
            // 익셉션 핸들러 추후 작업 진행 예정
            return new ResVo(Const.FAIL);
        }
        if (selReview == 1){
            // 익셉션 핸들러 추후 작업 진행 예정
            mapper.delReviewByReview(dto);
            mapper.delReview(dto);
        }
        return new ResVo(Const.SUCCESS);
    }
}
