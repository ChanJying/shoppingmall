package chanjy.service;

import chanjy.pojo.Collect;
import chanjy.vo.CollectVo;

import java.util.List;

public interface CollectService {
    List<CollectVo> queryCollectByCustomerId(int customerId);

    int addCollect(Collect collect);

    int deleteCollect(Collect collect);

    int deleteCollectByCollectId(int collectId);

    Collect queryCollectByCIdAndGId(Collect collect);
}
