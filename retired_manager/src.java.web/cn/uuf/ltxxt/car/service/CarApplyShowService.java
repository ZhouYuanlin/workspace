package cn.uuf.ltxxt.car.service;

import java.text.ParseException;
import java.util.List;

import cn.uuf.domain.car.Carapply;

/**
 * 车辆使用申请管理
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
public interface CarApplyShowService {
	
	public List<Carapply> find();
	public void save(Carapply t);
	public void update(Carapply t);
	public void delete(Long... id);
	public Carapply getById(Long id);
	public Long getCount(Carapply c,String workTime ,String onclickState);
	public List<Carapply> queryList(Carapply c,int s,int size,String workTime,String onclickState);
	public int dayforwork(String time) throws ParseException;
}

