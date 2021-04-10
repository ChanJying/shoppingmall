package chanjy.mapper;


import chanjy.pojo.Collect;
import chanjy.vo.CollectVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper {

   List<CollectVo> queryCollectByCustomerId(int customerId);

   int addCollect(Collect collect);

   int deleteCollect(Collect collect);

   int deleteCollectByCollectId(int collectId);

   Collect queryCollectByCollectId(int collectId);

   Collect queryCollectByCIdAndGId(Collect collect);

}
