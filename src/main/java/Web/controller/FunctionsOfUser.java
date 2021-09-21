package Web.controller;

import Web.DAO.impl.*;
import Web.Entity.Incident;
import Web.Entity.Service;

public class FunctionsOfUser {

    public static IncidentDAO incidentDAO = new IncidentDAO();
    public static ProfileDAO profileDAO = new ProfileDAO();
    public static ServiceDAO serviceDAO = new ServiceDAO();
    public static UserDAO userDAO = new UserDAO();
    public static UserRoleDAO userRoleDAO = new UserRoleDAO();

    public static void unsubscribeService(int userId, int serviceId) {
        Web.Entity.User user = userDAO.getById(2);
        Service service = serviceDAO.getById(2);

        user.getServices().remove(user.getServices().stream().findFirst().get());
        service.getUsers().remove(service.getUsers().stream().findFirst().get());

        userDAO.update(user);
        serviceDAO.update(service);
    }

    public static void subscribeService(int idUser, int idService) {
        Web.Entity.User userByID = userDAO.getById(idUser);
        Service serviceByID = serviceDAO.getById(idService);

        userByID.getServices().add(serviceByID);
        serviceByID.getUsers().add(userByID);

        serviceDAO.update(serviceByID);
    }

    public static void createIncident(int userID, String name, String description) {
        Web.Entity.User userByID = userDAO.getById(userID);

        Incident incident = new Incident();
        incident.setServiceName("Some Name of Incident");
        incident.setActive(true);
        incident.setProblemDescription("Some problem with something");
        incident.setUsers(userByID);

        incidentDAO.save(incident);
    }
}
