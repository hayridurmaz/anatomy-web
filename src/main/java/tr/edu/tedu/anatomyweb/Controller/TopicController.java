package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Repository.TopicRepository;
import tr.edu.tedu.anatomyweb.Service.ISystemService;
import tr.edu.tedu.anatomyweb.Service.ITopicService;
import tr.edu.tedu.anatomyweb.Service.TopicService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class TopicController {

    @Autowired
    ITopicService topicService;

    @GetMapping("/Topics")
    List<TOPIC> getTopics(){
        List<TOPIC> topics = (List<TOPIC>) topicService.findAll();
        return topics;
    }

    @PostMapping("/Topics")
    public TOPIC createTopic(@Valid @RequestBody TOPIC topic) {
        return topicService.save(topic);
    }

    @PutMapping("/Topics/{TopicId}")
    public TOPIC updateTopic(@PathVariable Long SystemId,
                               @Valid @RequestBody TOPIC tRequest) {
        TOPIC t = topicService.findById(SystemId);
        t.setNAME(tRequest.getNAME());
        return topicService.save(t);
    }

    @DeleteMapping("/Topics/{TopicId}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long topicId) {
        topicService.delete(topicId);
        return ResponseEntity.ok().build();
    }
}
