package com.foro.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foro.api.dto.ItemDTO;
import com.foro.api.dto.OrderDetailDTO;
import com.foro.common.exception.BizIllegalException;
import com.foro.common.utils.BeanUtils;
import com.foro.item.domain.po.Item;
import com.foro.item.mapper.ItemMapper;
import com.foro.item.service.IItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author Ayfwq
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Override
    @Transactional
    public void deductStock(List<OrderDetailDTO> items) {
        String sqlStatement = "item.mapper.ItemMapper.updateStock";
        boolean r = false;
        try {
            r = executeBatch(items, (sqlSession, entity) -> sqlSession.update(sqlStatement, entity));
        } catch (Exception e) {
            throw new BizIllegalException("更新库存异常，可能是库存不足!", e);
        }
        if (!r) {
            throw new BizIllegalException("库存不足！");
        }
    }

    @Override
    @Transactional
    public List<ItemDTO> queryItemByIds(Collection<Long> ids) {
        return BeanUtils.copyList(listByIds(ids), ItemDTO.class);
    }
}
