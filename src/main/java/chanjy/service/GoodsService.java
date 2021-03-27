package chanjy.service;

import chanjy.pojo.Goods;
import chanjy.pojo.Type;
import chanjy.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    List<GoodsVo> queryGoodsByLimit();

    List<Type> queryType();

    Type queryTypeById(int id);

    List<GoodsVo> queryGoodsByType(int typeId);

    GoodsVo queryGoodsById(int id);

    List<GoodsVo> queryBySearch(String searchName);


}
