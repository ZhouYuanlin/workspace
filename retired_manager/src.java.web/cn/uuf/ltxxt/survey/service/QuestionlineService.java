package cn.uuf.ltxxt.survey.service;

import cn.uuf.domain.survey.Questionline;

public interface QuestionlineService {
	public void save(Questionline q);
	public void update(Questionline q);
	public void delete(Long... id);
}
