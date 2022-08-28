package cn.riest.controller;


import cn.riest.entity.PowerAutogatherterminalnewest;
import cn.riest.service.impl.PowerAutogatherterminalnewestServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 租户--采集--终端设备自动采集表--电流电量电压功率--最新值 前端控制器
 * </p>
 *
 * @author dgj
 * @since 2021-09-23
 */
@RestController
@RequestMapping("/riest/power")
public class PowerAutogatherterminalnewestController {

    @Autowired
    PowerAutogatherterminalnewestServiceImpl autogatherterminalnewestService;

    @GetMapping(value = "/getdata")
    public List<PowerAutogatherterminalnewest> getSinageData() {
//        Wrapper<T> tWrapper = ;
        return autogatherterminalnewestService.list();
    }

}
