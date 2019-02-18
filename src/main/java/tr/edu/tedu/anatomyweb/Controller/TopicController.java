package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Service.ITopicService;

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
    public ResponseEntity<?> deleteTopic(@PathVariable Long TopicId) {
        topicService.delete(TopicId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/Topics/{TopicId}")
    TOPIC GetTopicById(@PathVariable Long TopicId) {
        TOPIC t = topicService.findById(TopicId);
        return t;
    }
}
