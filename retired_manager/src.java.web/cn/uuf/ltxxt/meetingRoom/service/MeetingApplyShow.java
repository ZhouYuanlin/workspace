package cn.uuf.ltxxt.meetingRoom.service;

import java.text.ParseException;
import java.util.List;

import cn.uuf.domain.meetingroom.MeetingApply;;
public interface MeetingApplyShow {

	public void save(MeetingApply m);
	public void update(MeetingApply m);
	public void delete(Long... id);
	public MeetingApply getById(Long id);
	public Long getCount(MeetingApply m,String workTime,String onclickState);
	public List<MeetingApply> queryList(MeetingApply m,int s,int size,String workTime,String onclickState);
	public int dayforwork(String time) throws ParseException;
}
