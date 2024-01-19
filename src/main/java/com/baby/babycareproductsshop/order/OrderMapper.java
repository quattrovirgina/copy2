package com.baby.babycareproductsshop.order;

import com.baby.babycareproductsshop.order.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface OrderMapper {

    int insOrder(InsOrderDto dto);
    // 주문 결제

    List<GetAfterOrderVo> getAfterOrder(GetAfterOrderDto dto);

    List<GetOrderDto> getOrder(GetOrderDto dto);

    List<GetAfterRefundVo> getAfterRefund(GetAfterRefundDto dto);

    int cancelOrder(CancelOrderDto dto);

    int refundOrder(RefundOrderDto dto);
}
