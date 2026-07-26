package com.car.rental.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.car.rental.common.Result;
import com.car.rental.dto.StoreQueryDTO;
import com.car.rental.entity.Store;
import com.car.rental.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * B端 - 门店管理控制器
 */
@RestController
@RequestMapping("/admin/store")
@RequiredArgsConstructor
public class StoreManageController {

    private final StoreService storeService;

    /**
     * 门店列表（分页）
     */
    @GetMapping("/list")
    public Result<IPage<Store>> list(StoreQueryDTO dto) {
        IPage<Store> page = storeService.queryPage(dto);
        return Result.success(page);
    }

    /**
     * 门店详情
     */
    @GetMapping("/{id}")
    public Result<Store> detail(@PathVariable Long id) {
        Store store = storeService.getDetail(id);
        return Result.success(store);
    }

    /**
     * 添加门店
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody Store store) {
        storeService.addStore(store);
        return Result.success("添加成功");
    }

    /**
     * 更新门店
     */
    @PutMapping("/update")
    public Result<String> update(@RequestBody Store store) {
        storeService.updateStore(store);
        return Result.success("更新成功");
    }

    /**
     * 删除门店
     */
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id) {
        storeService.deleteStore(id);
        return Result.success("删除成功");
    }

    /**
     * 更新门店状态
     */
    @PutMapping("/{id}/status")
    public Result<String> updateStatus(@PathVariable Long id, @RequestParam Integer status) {
        storeService.updateStatus(id, status);
        return Result.success("状态更新成功");
    }

    /**
     * 根据城市编码查询门店列表
     */
    @GetMapping("/list/{cityCode}")
    public Result<List<Store>> listByCityCode(@PathVariable String cityCode) {
        List<Store> list = storeService.listByCityCode(cityCode);
        return Result.success(list);
    }
}
