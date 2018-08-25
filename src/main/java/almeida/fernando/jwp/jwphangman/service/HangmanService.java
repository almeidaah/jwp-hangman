package almeida.fernando.jwp.jwphangman.service;

import almeida.fernando.jwp.jwphangman.domain.HangmanGame;
import almeida.fernando.jwp.jwphangman.repository.HangmanGameRepository;
import almeida.fernando.jwp.jwphangman.repository.HangmanPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HangmanService {
    @Autowired
    HangmanGameRepository gameRepository;

    @Autowired
    HangmanPassRepository passRepository;
    public HangmanGame.HangmanData start() {

        HangmanGame game = new HangmanGame();
        HangmanGame.HangmanData data = game.start(passRepository.draw());
        long id = gameRepository.create(data);
        data.setId(id);
        return data;
    }


    public HangmanGame.HangmanData play(Long id, Character attempt) {
        HangmanGame game = new HangmanGame();
        HangmanGame.HangmanData data = gameRepository.update(id, attempt);
        game.start(data.getPass());
        return game.play(data.getAttempts().toArray(new Character[data.getAttempts().
                size()]));
    }
}