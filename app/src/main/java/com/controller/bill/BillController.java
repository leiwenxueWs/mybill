package com.controller.bill;

import com.dto.common.CreateAccountDto;
import com.dto.request.AddAmountRequestDto;
import com.dto.request.AddSpeciesRequestDto;
import com.dto.response.AccountResponseDto;
import com.dto.response.AmountResponseDto;
import com.model.auto.Species;
import com.service.BillService;
import com.util.RestResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName BillController
 * @desc BillController
 * @date 2019/4/2 下午2:30
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    /**
     * 获得记录种类
     *
     * @param accountNumber userNumber
     * @param type          类型 0:支出、1:收入
     * @return
     */
    @GetMapping("/getSpecies")
    public RestResponse<List<Species>> getSpecies(@Param("accountNumber") long accountNumber, @Param("type") int type) {
        return RestResponse.success(billService.getSpecies(accountNumber, type));
    }

    /**
     * 获取已删除的系统类别
     * @param accountNumber
     * @param type
     * @return
     */
    @GetMapping("/getDelSystemSpecies")
    public RestResponse<List<Species>> getDelSystemSpecies(@Param("accountNumber") long accountNumber, @Param("type") int type){
        return RestResponse.success(billService.getDelSystemSpecies(accountNumber, type));
    }

    /**
     * 添加Species
     * @param addSpeciesRequestDto
     * @return
     */
    @PostMapping("/addSpecies")
    public RestResponse<Integer> addSpecies(@RequestBody AddSpeciesRequestDto addSpeciesRequestDto) {
        if(billService.isHadSameSpecies(addSpeciesRequestDto)){
            return RestResponse.fail("该类别名称已存在");
        }
        return RestResponse.success(billService.addSpecies(addSpeciesRequestDto));
    }

    @GetMapping("deleteSpecies")
    public RestResponse<Boolean> deleteSpecies(@RequestParam("speciesNumber") Long speciesNumber1){
        if(speciesNumber1==null || speciesNumber1.equals(0L)){
            RestResponse.fail("删除类别异常");
        }
        return RestResponse.success(billService.deleteSpecies(speciesNumber1));
    }

    @GetMapping("addSystemSpecies")
    public RestResponse<Boolean> addSystemSpecies(@RequestParam("speciesNumber") Long speciesNumber){
        if(speciesNumber==null || speciesNumber.equals(0L)){
            RestResponse.fail("添加类别异常");
        }
        return RestResponse.success(billService.addSystemSpecies(speciesNumber));
    }

    @PostMapping("addAmount")
    public RestResponse<Integer> addAmount(@RequestBody AddAmountRequestDto addAmountRequestDto){
        return RestResponse.success(billService.addAmount(addAmountRequestDto));
    }

    /**
     * 获取帐单记录
     * @param accountNumber
     * @param type
     * @return
     */
    @GetMapping("getAmount")
    public RestResponse<List<AmountResponseDto>> getAmount(long accountNumber,Integer type){
        return RestResponse.success(billService.getAmount(accountNumber,type));
    }


    @GetMapping("/getAmountById")
    public RestResponse<AmountResponseDto> getAmountById(@RequestParam("id") Integer id){
        return RestResponse.success(billService.getAmountById(id));
    }

    @GetMapping("/deleteAmountById")
    public RestResponse<Integer> deleteAmountById(@RequestParam("id") Integer id){
        return RestResponse.success(billService.deleteAmountById(id));
    }

    /**
     * 创建帐单
     * @param createAccountDto
     * @return
     */
    @PostMapping("/createAccount")
    public RestResponse<Boolean> createAccount(@RequestBody CreateAccountDto createAccountDto) {
        if (billService.isHadSameNameAccount(createAccountDto)) {
            return RestResponse.fail("帐单名称已存在");
        }
        billService.createAccount(createAccountDto);
        return RestResponse.success(true);
    }

    /**
     * 获取用户帐单
     * @param userNumber
     * @return
     */
    @GetMapping("/getAccount")
    public RestResponse<List<AccountResponseDto>> getAccount(long userNumber){
       return RestResponse.success(billService.getAccountByUserNumber(userNumber));
    }

    /**
     * 删除帐单
     * @param accountNumber
     * @return
     */
    @GetMapping("deleteAccount")
    public RestResponse<Boolean> deleteAccount(@Param("accountNUmber") long accountNumber){
        return RestResponse.success(billService.deleteAccount(accountNumber));
    }


}
