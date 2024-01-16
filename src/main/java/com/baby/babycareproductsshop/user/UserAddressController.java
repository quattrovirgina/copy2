package com.baby.babycareproductsshop.user;

import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.user.model.UserDelAddressDto;
import com.baby.babycareproductsshop.user.model.UserInsAddressDto;
import com.baby.babycareproductsshop.user.model.UserSelAddressVo;
import com.baby.babycareproductsshop.user.model.UserUpdAddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/address")
public class UserAddressController {
    private final UserService service;
    @PostMapping
    public ResVo postUserAddress(@RequestBody UserInsAddressDto dto){
        return service.postUserAddress(dto);
    }

    @GetMapping
    public List<UserSelAddressVo> getUserAddress() {
        return service.getUserAddress();
    }

    @PutMapping
    public ResVo putUserAddress(@RequestBody UserUpdAddressDto dto) {
        return service.putUserAddress(dto);
    }

    @DeleteMapping
    public ResVo delUserAddress(UserDelAddressDto dto) {
        return service.delUserAddress(dto);
    }
}
