package cn.uuf.ltxxt.meetingRoom.service;

import java.util.List;

import cn.uuf.domain.CodeBjbj;
import cn.uuf.domain.meetingroom.MeetingRoom;

public interface MeetingRoomService {
	public void save(MeetingRoom m);

	public void update(MeetingRoom m);

	public void delete(Long... id);

	public MeetingRoom getById(Long id);

	public Long getCount(MeetingRoom m);

	public List<MeetingRoom> queryList(MeetingRoom m, int s, int size);

	public List<MeetingRoom> find();

	public List<MeetingRoom> getAll();

}