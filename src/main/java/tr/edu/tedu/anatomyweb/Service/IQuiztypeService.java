package tr.edu.tedu.anatomyweb.Service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IQuiztypeService {

    public List<QUIZTYPE> findAll();
    public QUIZTYPE save(QUIZTYPE quiztype);
    public Optional<QUIZTYPE> findById(long quiztypeId);
    public void delete(QUIZTYPE quiztype);
}
