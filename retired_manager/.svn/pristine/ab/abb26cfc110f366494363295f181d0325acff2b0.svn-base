package cn.uuf.ltxxt.asset.service;

import java.util.List;

import cn.uuf.domain.asset.AssetManage;
import cn.uuf.domain.asset.AssetFushu;



public interface AssetFushuService {
	public void save(AssetFushu m);

	public void update(AssetFushu m);

	public void delete(Long... id);

	public AssetFushu getById(Long id);
	public Long getCount(AssetFushu m);

	public List<AssetFushu> queryList(AssetFushu a, int s, int size);

	public List<AssetFushu> find();

	public List<AssetFushu> getAll();

	public String fmtLong(Long val, int size);
	
	public List queryBySql(String sql)throws Exception;

	public void updateHQL(String sql);
	public List<AssetFushu> findByCriteria(AssetFushu am)throws Exception;
	public List<AssetFushu> findByTj(AssetFushu am)throws Exception;
}
