package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Repository.TopicRepository;

import java.util.List;

@Service
public class TopicService implements ITopicService {

    @Autowired
    private TopicRepository repository;

    @Override
    public List<TOPIC> findAll() {
        return repository.findAll();
    }

    @Override
    public TOPIC save(TOPIC topic) {
        return repository.save(topic);
    }

    @Override
    public TOPIC findById(long topicId) {
        TOPIC t = repository.findById(topicId)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found with id " + topicId));
        return t;
    }

    @Override
    public String delete(Long topicId) {
        try {
            repository.deleteById(topicId);
            return "Deleted";
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null) {
                t = t.getCause();
            }
            return "Cannot delete: " + t.getMessage();
        }
    }
}
