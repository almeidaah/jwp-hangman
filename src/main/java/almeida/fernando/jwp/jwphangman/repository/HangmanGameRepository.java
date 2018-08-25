package almeida.fernando.jwp.jwphangman.repository;

import java.util.HashMap;
import java.util.Map;

import almeida.fernando.jwp.jwphangman.domain.HangmanGame;
import org.springframework.stereotype.Repository;

@Repository
public class HangmanGameRepository {
    private Map<Long,HangmanGame.HangmanData> map = new HashMap<>();
    public long create(HangmanGame.HangmanData data) {
        long id = System.currentTimeMillis();
        map.put(id, data);
        return id;
    }
    public HangmanGame.HangmanData update(Long id, Character attempt) {
        HangmanGame.HangmanData data = map.get(id);
        data.update(attempt);
        return data;
    }
}