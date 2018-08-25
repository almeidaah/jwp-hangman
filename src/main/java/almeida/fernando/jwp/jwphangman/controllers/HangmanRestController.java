package almeida.fernando.jwp.jwphangman.controllers;

import almeida.fernando.jwp.jwphangman.domain.HangmanGame;
import almeida.fernando.jwp.jwphangman.service.HangmanService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HangmanRestController{

    @Autowired
    HangmanService hangmanService;

    @GetMapping("/api/games")
    public HangmanResponse start(String action) {
        if ("start".equals(action)) {
            HangmanGame.HangmanData data = hangmanService.start();
            return HangmanResponse.builder()
                    .id(data.getId())
                    .board(data.getBoard())
                    .message(data.getMessage())
                    .missesCounter(data.getMissesCounter())
                    .missesLimit(data.getMissesLimit())
                    .build();
        }
        return null;
    }

    @GetMapping("/api/games/{id}/attempts")
    public HangmanResponse play(@PathVariable Long id, String action, Character attempt) {
        if ("play".equals(action)) {
            HangmanGame.HangmanData data = hangmanService.play(id, attempt);
            return HangmanResponse.builder()
                    .id(data.getId())
                    .board(data.getBoard())
                    .message(data.getMessage())
                    .missesCounter(data.getMissesCounter())
                    .missesLimit(data.getMissesLimit())
                    .build();
        }
        return null;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HangmanResponse {
            private long id;
            private String board;
            private String message;
            private int missesCounter;
            private int missesLimit;
            public String getMisses() {
                return String.format("%d/%s", missesCounter, missesLimit);
            }
        }

}
