package chanjy.service.impl;

import chanjy.mapper.GoodsMapper;
import chanjy.pojo.Goods;
import chanjy.pojo.Type;
import chanjy.service.GoodsService;
import chanjy.vo.GoodsListVo;
import chanjy.vo.GoodsVo;
import chanjy.vo.OrderDetailVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public int deleteGoodsType(int id) {
        return goodsMapper.deleteGoodsType(id);
    }

    @Override
    public int insertGoodsType(String typeName) {
        return goodsMapper.insertGoodsType(typeName);
    }

    @Override
    public int updateGoodsType(Type type) {
        return goodsMapper.updateGoodsType(type);
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public GoodsListVo selectAllToVoByGoodsId(int goodsId) {
        return goodsMapper.selectAllToVoByGoodsId(goodsId);
    }

    @Override
    public PageInfo<GoodsListVo> selectAllToVo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsListVo> goodsListVos = goodsMapper.selectAllToVo();
        PageInfo<GoodsListVo> pageInfo = new PageInfo<>(goodsListVos);
        return pageInfo;
    }


}
