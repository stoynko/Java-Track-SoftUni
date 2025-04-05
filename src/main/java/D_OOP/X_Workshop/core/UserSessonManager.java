package D_OOP.X_Workshop.core;

import D_OOP.X_Workshop.entities.user.*;

public class UserSessionManager implements SessionManager<User> {

    @Override
    public User getActiveSession() {
        return null;
    }

    @Override
    public void setActiveSession(User user) {

    }

    @Override
    public boolean hasActiveSession() {
        return false;
    }

    @Override
    public void terminateActiveSession() {

    }
}
