package annotations_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService{
    @Autowired
    @Value("${fortunes}")
    private String fortune;
    @Override
    public String getFortune() {
        return fortune;
    }
}
