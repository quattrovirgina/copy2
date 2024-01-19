package com.baby.babycareproductsshop.order;

import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.order.model.InsOrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/order")

public class OrderController {
    private final OrderService service;

    @PostMapping("/buyorder")
    public ResVo insertorder(@RequestBody InsOrderDto dto) {
        ResVo vo = service.orderins(dto);
        log.info("result: {}", dto);

        return vo;
    }

}
