package com.baby.babycareproductsshop.order;

import com.baby.babycareproductsshop.common.Const;
import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {
    private final OrderMapper mapper;

    public ResVo orderins(InsOrderDto dto) {

        int result = mapper.insOrder(dto);

        if(result == 0) {
            return new ResVo(Const.FAIL);
        }

        return new ResVo(Const.SUCCESS);


    }

    public List<GetAfterOrderVo> orderafter(GetAfterOrderDto dto) {

        List<GetAfterOrderVo> li = mapper.getAfterOrder(dto);

    }
    public ResVo ordercancel(CancelOrderDto dto) {

        int result = mapper.cancelOrder(dto);

        if(result == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo orderrefund(RefundOrderDto dto) {
        int result = mapper.refundOrder(dto);

        if(result == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }
}
