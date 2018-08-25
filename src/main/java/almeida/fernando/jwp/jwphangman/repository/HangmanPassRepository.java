package almeida.fernando.jwp.jwphangman.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Repository;

@Repository
public class HangmanPassRepository {
    private static final List<String> passList = Arrays.asList("Function", "Predicate", "Supplier", "Consumer", "Stream");
    public String draw() {
        int index = new Random().nextInt(passList.size());
        return passList.get(index);
    }
}