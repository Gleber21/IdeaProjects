package serv.repo;


public interface Repo<T> {
    void save(T text);
    T load();
}
