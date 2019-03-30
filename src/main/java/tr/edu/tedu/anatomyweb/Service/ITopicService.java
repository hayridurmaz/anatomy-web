package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.TOPIC;

import java.util.List;

public interface ITopicService {

    List<TOPIC> findAll();

    TOPIC save(TOPIC topic);

    TOPIC findById(long topicId);

    String delete(Long topicId);
}
