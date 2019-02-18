package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Repository.TopicRepository;
import tr.edu.tedu.anatomyweb.Service.ISystemService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class TopicController {

    @Autowired
    TopicRepository repository;

    @GetMapping("/GetTopics")
    List<TOPIC> topics(){
        List<TOPIC> topics = (List<TOPIC>) repository.findAll();
        return topics;
    }

    @PostMapping("/CreateTopic")
    public TOPIC createTopic(@Valid @RequestBody TOPIC topic) {
        return repository.save(topic);
    }

    @PutMapping("/UpdateTopic/{TopicId}")
    public TOPIC updateSystem(@PathVariable Long TopicId,
                               @Valid @RequestBody TOPIC topicRequest) {
        TOPIC t = repository.findById(TopicId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + TopicId));
        t.setNAME(topicRequest.getNAME());
        return repository.save(t);
    }

    @DeleteMapping("/DeleteTopic/{TopicId}")
    public ResponseEntity<?> deleteSystem(@PathVariable Long topicId) {
        TOPIC t = repository.findById(topicId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + topicId));;;
        repository.delete(t);
        return ResponseEntity.ok().build();

    }
}
