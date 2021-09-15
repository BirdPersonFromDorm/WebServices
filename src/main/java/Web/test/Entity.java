package Web.test;

import lombok.Data;

@Data
public class Entity {

    private int entityID;
    private String login;
    private String password;
    private String cart;
    private String managerName;

    public static void main(String[] args) {

        Entity entity = new Entity();
        entity.setLogin("SameThing");
        entity.setPassword("123");
        entity.setCart("new");
        entity.setManagerName("Manager");

        EntityDTO entityDTO = new EntityDTO();
        entityDTO.setName(entity.getLogin());
        entityDTO.setCart(entity.getCart());
        entityDTO.setManagerName(entity.getManagerName());

        System.out.println(entityDTO);
    }

}

@Data
class EntityDTO{
    private String name;
    private String cart;
    private String managerName;
}
