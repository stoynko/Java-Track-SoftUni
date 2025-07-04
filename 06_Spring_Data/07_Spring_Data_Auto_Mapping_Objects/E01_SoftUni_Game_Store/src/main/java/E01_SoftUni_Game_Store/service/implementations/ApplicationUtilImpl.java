package E01_SoftUni_Game_Store.service.implementations;

import E01_SoftUni_Game_Store.service.utilities.*;
import org.springframework.boot.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

@Service
public class ApplicationUtilImpl implements ApplicationUtil  {

    private final ApplicationContext context;

    public ApplicationUtilImpl(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void shutdown() {
        int exitCode = SpringApplication.exit(context, () -> 0);
        System.exit(exitCode);
    }
}
