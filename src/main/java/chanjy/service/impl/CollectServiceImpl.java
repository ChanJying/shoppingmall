package chanjy.service.impl;

import chanjy.exception.GlobalException;
import chanjy.mapper.CollectMapper;
import chanjy.pojo.Collect;
import chanjy.result.CodeMsg;
import chanjy.service.CollectService;
import chanjy.vo.CollectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;


    @Override
    public List<CollectVo> queryCollectByCustomerId(int customerId) {
        return collectMapper.queryCollectByCustomerId(customerId);
    }

    @Override
    public int addCollect(Collect collect) {
        Collect collect1 = collectMapper.queryCollectByCIdAndGId(collect);
        if(collect1 !=null) throw new GlobalException(CodeMsg.COLLECT_EXIST);
        return collectMapper.addCollect(collect);
    }

    @Override
    public int deleteCollect(Collect collect) {
        Collect collect1 = collectMapper.queryCollectByCIdAndGId(collect);
        if(collect1 ==null) throw new GlobalException(CodeMsg.COLLECT_NOT_EXIST);
        return collectMapper.deleteCollect(collect);
    }

    @Override
    public int deleteCollectByCollectId(int collectId) {
        Collect collect1 = collectMapper.queryCollectByCollectId(collectId);
        if(collect1 ==null) throw new GlobalException(CodeMsg.COLLECT_NOT_EXIST);
        return collectMapper.deleteCollectByCollectId(collectId);
    }

    @Override
    public Collect queryCollectByCIdAndGId(Collect collect) {
        return collectMapper.queryCollectByCIdAndGId(collect);
    }


}
