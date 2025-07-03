package E01_SoftUni_Game_Store.service.implementations;

import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.service.*;
import org.springframework.stereotype.*;

@Service
public class UserSessionManager implements SessionManager<User> {

    private User currentActiveUser;

    public UserSessionManager() {
        this.currentActiveUser = null;
    }

    @Override
    public User getActiveSession() {
        return this.currentActiveUser;
    }

    @Override
    public void setActiveSession(User user) {
        this.currentActiveUser = user;
    }

    @Override
    public boolean hasActiveSession() {
        return this.currentActiveUser != null;
    }

    @Override
    public void terminateActiveSession() {
        this.currentActiveUser = null;
    }
}
