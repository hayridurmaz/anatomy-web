package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Service.IQuizService;
import tr.edu.tedu.anatomyweb.Service.ISystemService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class SystemController {

    @Autowired
    ISystemService systemService;

    @GetMapping("/Systems")
    List<SYSTEM> getSystems() {
        return systemService.findAll();
    }

    @GetMapping("/GetSystemById/{SystemId}")
    SYSTEM GetSystemById(@PathVariable Long SystemId) {
        SYSTEM s = systemService.findById(SystemId);
        return s;
    }

    @PostMapping("/CreateSystem")
    public SYSTEM createSystem(@Valid @RequestBody SYSTEM system) {
        return systemService.save(system);
    }

    @PutMapping("/Systems/{SystemId}")
    public SYSTEM updateSystem(@PathVariable Long SystemId, @Valid @RequestBody SYSTEM systemRequest) {
        SYSTEM s = systemService.findById(SystemId);
        s.setNAME(systemRequest.getNAME());
        return systemService.save(s);
    }

    @DeleteMapping("/Systems/{SystemId}")
    public ResponseEntity<?> deleteSystem(@PathVariable Long systemId) {
        systemService.delete(systemId);
        return ResponseEntity.ok().build();

    }
}
