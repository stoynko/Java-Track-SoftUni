package E01_SoftUni_Game_Store.service;

public interface SessionManager<T> {
    T getActiveSession();
    void setActiveSession(T t);
    boolean hasActiveSession();
    void terminateActiveSession();
}
