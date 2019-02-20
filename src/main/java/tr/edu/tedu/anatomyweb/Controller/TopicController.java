package tr.edu.tedu.anatomyweb.Controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Service.ITopicService;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class TopicController {

    @Autowired
    ITopicService topicService;

    @GetMapping("/Topics")
    List<TOPIC> getTopics() {
        List<TOPIC> topics = (List<TOPIC>) topicService.findAll();
        return topics;
    }

    @GetMapping("/Topics/{TopicId}")
    TOPIC GetTopicById(@PathVariable Long TopicId) {
        TOPIC t = topicService.findById(TopicId);
        return t;
    }

    @PostMapping("/Topics")
    public TOPIC createTopic(@Valid @RequestBody TOPIC topic) {
        return topicService.save(topic);
    }

    @PutMapping("/Topics/{TopicId}")
    public TOPIC updateTopic(@PathVariable Long TopicId, @Valid @RequestBody TOPIC tRequest) {
        TOPIC t = topicService.findById(TopicId);
        t.setNAME(tRequest.getNAME());
        return topicService.save(t);
    }

    @DeleteMapping("/Topics/{TopicId}")
    public String deleteTopic(@PathVariable Long TopicId) {
        return topicService.delete(TopicId);
    }

}
