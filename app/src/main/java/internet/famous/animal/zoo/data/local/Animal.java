package internet.famous.animal.zoo.data.local;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;
import javax.inject.Inject;

@Entity
public final class Animal {
  @Id public long id;
  public String name;
  public ToOne<Species> species;
  public ToOne<Pen> pen;

  @Inject
  public Animal() {}
}
