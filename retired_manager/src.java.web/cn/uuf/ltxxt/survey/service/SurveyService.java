package cn.uuf.ltxxt.survey.service;

import java.util.List;

import cn.uuf.domain.survey.Questionten;
import cn.uuf.domain.survey.Survey;

public interface SurveyService {
	public List<Survey> queryList(Survey s,int c,int size);
	public Long getCount(Survey s);
	public void save(Survey s);
	public void update(Survey s);
	public Survey getById(Long id);//查看详情
	public void delete(Long... id);
	public List<Survey> getAll();
	public List<Questionten> queryBySid(Questionten questionten);
	public List queryBySql(String sql);//查询数据
}
