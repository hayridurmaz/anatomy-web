package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Repository.QuizTypeRepository;

import java.util.List;


@Service
    public class QuiztypeService implements IQuiztypeService {

        @Autowired
        private QuizTypeRepository repository;

        @Override
        public List<QUIZTYPE> findAll() {
            List<QUIZTYPE> cities = (List<QUIZTYPE>) repository.findAll();
            return cities;
        }

}
