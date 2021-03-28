package chanjy.mapper;

import chanjy.pojo.Goods;
import chanjy.pojo.Type;
import chanjy.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    List<GoodsVo> queryGoodsByLimit();

    List<Type> queryType();

    Type queryTypeById(int id);

    List<GoodsVo> queryGoodsByType(int typeId);

    GoodsVo queryGoodsById(int id);

    List<GoodsVo> queryBySearch(String searchName);

    int updateGoodsNums(@Param("id")int goodsId,@Param("goodsNums")int goodsNums);
}
