package chanjy.service;

import chanjy.pojo.Goods;
import chanjy.pojo.Type;
import chanjy.vo.GoodsListVo;
import chanjy.vo.GoodsVo;
import chanjy.vo.OrderDetailVo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {

    List<GoodsVo> queryGoodsByLimit();

    List<Type> queryType();

    Type queryTypeById(int id);

    List<GoodsVo> queryGoodsByType(int typeId);

    GoodsVo queryGoodsById(int id);

    List<GoodsVo> queryBySearch(String searchName);

    int updateGoodsNums (int goodsId, int goodsNums);

    PageInfo<GoodsListVo> selectAllToVo(int pageNum, int pageSize);

    GoodsListVo selectAllToVoByGoodsId(int goodsId);

    int updateGoods(Goods goods);

    int insertGoods(Goods goods);

    int updateGoodsType(int id,String typeName);

    int deleteGoodsType(int id);

    int insertGoodsType(String typeName);

}
