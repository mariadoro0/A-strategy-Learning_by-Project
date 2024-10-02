@Getter
@Setter
@Entity
@Table(name ="user_collection")
public class UserCollection{

  @EmbeddedId
  private CollectionKey id;
  private int quantity;


}
