package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public SYSTEM createTopic(@Valid @RequestBody SYSTEM system) {
        return systemService.save(system);
    }

    @PutMapping("/UpdateTopic/{TopicId}")
    public SYSTEM updateSystem(@PathVariable Long SystemId,
                               @Valid @RequestBody SYSTEM systemRequest) {
        SYSTEM s = systemService.findById(SystemId);
        s.setNAME(systemRequest.getNAME());
        return systemService.save(s);
    }

    @DeleteMapping("/DeleteTopic/{TopicId}")
    public ResponseEntity<?> deleteSystem(@PathVariable Long systemId) {
        systemService.delete(systemId);
        return ResponseEntity.ok().build();

    }
}
