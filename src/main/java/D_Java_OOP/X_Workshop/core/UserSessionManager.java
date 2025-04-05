package D_Java_OOP.X_Workshop.core;

import D_Java_OOP.X_Workshop.entities.user.*;

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
