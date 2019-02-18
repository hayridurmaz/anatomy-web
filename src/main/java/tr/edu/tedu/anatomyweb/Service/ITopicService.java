package tr.edu.tedu.anatomyweb.Service;


import tr.edu.tedu.anatomyweb.Model.TOPIC;

import java.util.List;

public interface ITopicService {

    public List<TOPIC> findAll();
    public TOPIC save(TOPIC topic);
    public TOPIC findById(long topicId);
    public void delete(Long topicId);
}
