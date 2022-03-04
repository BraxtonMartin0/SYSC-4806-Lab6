import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.*;

public interface BuddyRepo extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(@Param("name") String name);
}