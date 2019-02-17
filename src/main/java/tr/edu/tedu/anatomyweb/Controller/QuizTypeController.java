package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class QuizTypeController {


    @Autowired
    IQuiztypeService quiztypeService;

    @GetMapping(("/quiztypes"))
    List<QUIZTYPE> getQuiztypes() {
        List<QUIZTYPE> quiztypes = (List<QUIZTYPE>) quiztypeService.findAll();
        return quiztypes;
    }

    @PostMapping("/quiztypes")
    public QUIZTYPE createQuiztype(@Valid @RequestBody QUIZTYPE quiztype) {
        return quiztypeService.save(quiztype);
    }


    @PutMapping("/quiztypes/{quiztypeId}")
    public QUIZTYPE updateQuiztype(@PathVariable Long quiztypeId,
                                   @Valid @RequestBody QUIZTYPE quiztypeRequest) {
        QUIZTYPE q = quiztypeService.findById(quiztypeId);
        q.setNAME(quiztypeRequest.getNAME());
        return quiztypeService.save(q);
    }


    @DeleteMapping("/quiztypes/{quiztypeId}")
    public @ResponseBody ResponseEntity<?> deleteQuiztype(@PathVariable Long quiztypeId) {
        quiztypeService.delete(quiztypeId);
        return ResponseEntity.ok().build();
    }


}
