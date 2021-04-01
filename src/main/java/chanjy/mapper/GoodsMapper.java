package chanjy.mapper;

import chanjy.pojo.Goods;
import chanjy.pojo.Type;
import chanjy.vo.GoodsListVo;
import chanjy.vo.GoodsVo;
import chanjy.vo.OrderDetailVo;
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

    List<GoodsListVo> selectAllToVo();

    GoodsListVo selectAllToVoByGoodsId(int goodsId);

    int updateGoods(Goods goods);

    int insertGoods(Goods goods);

    int updateGoodsType(@Param("id")int id,@Param("typeName")String typeName);

    int deleteGoodsType(int id);

    int insertGoodsType(String typeName);
}
