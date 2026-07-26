package com.car.rental.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.car.rental.common.Result;
import com.car.rental.dto.UserQueryDTO;
import com.car.rental.entity.User;
import com.car.rental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * B端 - 用户管理控制器
 */
@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserManageController {

    private final UserService userService;

    /**
     * 用户列表（分页）
     */
    @GetMapping("/list")
    public Result<IPage<User>> list(UserQueryDTO dto) {
        IPage<User> page = userService.queryPage(dto);
        return Result.success(page);
    }

    /**
     * 用户详情
     */
    @GetMapping("/{id}")
    public Result<User> detail(@PathVariable Long id) {
        User user = userService.getDetailById(id);
        return Result.success(user);
    }

    /**
     * 更新用户状态
     */
    @PutMapping("/{id}/status")
    public Result<String> updateStatus(@PathVariable Long id, @RequestParam Integer status) {
        userService.updateStatus(id, status);
        return Result.success("状态更新成功");
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    public Result<String> update(@RequestBody User user) {
        userService.updateUserById(user);
        return Result.success("更新成功");
    }
}
