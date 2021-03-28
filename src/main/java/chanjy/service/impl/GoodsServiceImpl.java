package chanjy.service.impl;

import chanjy.mapper.GoodsMapper;
import chanjy.pojo.Goods;
import chanjy.pojo.Type;
import chanjy.service.GoodsService;
import chanjy.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public List<GoodsVo> queryGoodsByLimit(){
        return  goodsMapper.queryGoodsByLimit();

    }

    public List<Type> queryType(){
        return goodsMapper.queryType();
    }

    public Type queryTypeById(int id){ return goodsMapper.queryTypeById(id);}

    public List<GoodsVo> queryGoodsByType(int typeId){
        return goodsMapper.queryGoodsByType(typeId);
    }

    public GoodsVo queryGoodsById(int id){
        return goodsMapper.queryGoodsById(id);
    }

    public List<GoodsVo> queryBySearch(String searchName){
        return goodsMapper.queryBySearch(searchName);
    }

    public int updateGoodsNums(int goodsId, int goodsNums) {
        return goodsMapper.updateGoodsNums(goodsId,goodsNums);
    }
}
