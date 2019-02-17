package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Repository.QuizTypeRepository;
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class QuizTypeController {


    @Autowired
    IQuiztypeService quiztypeService;
    @Autowired
    QuizTypeRepository quizTypeRepository;

    @GetMapping(("/quiztypes"))
    List<QUIZTYPE> quizTypes() {
        List<QUIZTYPE> quiztypes = (List<QUIZTYPE>) quiztypeService.findAll();
        return quiztypes;
    }

    @PostMapping("/quiztypes")
    public QUIZTYPE createQuestion(@Valid @RequestBody QUIZTYPE quiztype) {
        return quiztypeService.save(quiztype);
    }


    @PutMapping("/quiztypes/{quiztypeId}")
    public QUIZTYPE updateQuiztype(@PathVariable Long quiztypeId,
                                   @Valid @RequestBody QUIZTYPE quiztypeRequest) {
        return quizTypeRepository.findById(quiztypeId)
                .map(quiztype -> {
                    quiztype.setNAME(quiztypeRequest.getNAME());
                    return quizTypeRepository.save(quiztype);
                }).orElseThrow(() -> new ResourceNotFoundException("Quiztype not found with id " + quiztypeId));
    }


    @DeleteMapping("/questions/{quiztypeId}")
    public ResponseEntity<?> deleteQuiztype(@PathVariable Long quiztypeId) {
        return quizTypeRepository.findById(quiztypeId)
                .map(quiztype -> {
                    quizTypeRepository.delete(quiztype);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Quiztype not found with id " + quiztypeId));
    }


}
