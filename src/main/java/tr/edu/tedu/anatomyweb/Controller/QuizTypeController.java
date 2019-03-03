package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class QuizTypeController {

    @Autowired
    IQuiztypeService quiztypeService;

    @GetMapping(("/Quiztypes"))
    List<QUIZTYPE> getQuiztypes() {
        List<QUIZTYPE> quiztypes = (List<QUIZTYPE>) quiztypeService.findAll();
        return quiztypes;
    }

    @GetMapping(("/Quiztypes/{QuiztypeId}"))
    QUIZTYPE getQuiztypeById(@PathVariable Long QuiztypeId) {
        QUIZTYPE qt = quiztypeService.findById(QuiztypeId);
        return qt;
    }

    @PostMapping("/Quiztypes")
    public QUIZTYPE createQuiztype(@Valid @RequestBody QUIZTYPE quiztype) {
        return quiztypeService.save(quiztype);
    }

    @PutMapping("/Quiztypes/{quiztypeId}")
    public QUIZTYPE updateQuiztype(@PathVariable Long quiztypeId, @Valid @RequestBody QUIZTYPE quiztypeRequest) {
        QUIZTYPE q = quiztypeService.findById(quiztypeId);
        q.setNAME(quiztypeRequest.getNAME());
        return quiztypeService.save(q);
    }

    @DeleteMapping("/Quiztypes/{quiztypeId}")
    public @ResponseBody
    String deleteQuiztype(@PathVariable Long quiztypeId) {
        return quiztypeService.delete(quiztypeId);
    }

}
