package dao;

public final class DAOFactory {

    public static UserDAO getUserDAO() {
        return new UserDAO();
    }

    public static EventDAO getEventDAO() {
        return new EventDAO();
    }

    public static DishDAO getDishDAO() {
        return new DishDAO();
    }

    public static ParticipantDAO getParticipantDAO() {
        return new ParticipantDAO();
    }
}
