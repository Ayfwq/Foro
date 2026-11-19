package com.foro.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.foro.user.domain.dto.LoginFormDTO;
import com.foro.user.domain.po.User;
import com.foro.user.domain.vo.UserLoginVO;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Ayfwq
 * @since 2023-05-05
 */
public interface IUserService extends IService<User> {

    UserLoginVO login(LoginFormDTO loginFormDTO);

    void deductMoney(String pw, Integer totalFee);
}
