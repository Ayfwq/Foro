package com.foro.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foro.user.domain.po.Address;
import com.foro.user.mapper.AddressMapper;
import com.foro.user.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ayfwq
 * @since 2023-05-05
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
