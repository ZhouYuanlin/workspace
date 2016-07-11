package cn.uuf.ltxxt.asset.service;

import java.util.List;

import cn.uuf.domain.asset.AssetFushu;
import cn.uuf.domain.asset.AssetRecord;


public interface AssetRecordService {
	public void save(AssetRecord m);

	public void update(AssetRecord m);

	public void delete(Long... id);

	public AssetRecord getById(Long id);
	public Long getCount(AssetRecord m);

	public List<AssetRecord> queryList(AssetRecord a, int s, int size);

	public List<AssetRecord> find();

	public List<AssetRecord> getAll();

	public String fmtLong(Long val, int size);
	
	public List queryBySql(String sql)throws Exception;
	public List queryByHql(String hql)throws Exception;
	public void updateHQL(String sql);
	public List<AssetRecord> findByCriteria(AssetRecord am)throws Exception;

	public List<AssetRecord> findByFushuId(AssetRecord record)throws Exception;

}
