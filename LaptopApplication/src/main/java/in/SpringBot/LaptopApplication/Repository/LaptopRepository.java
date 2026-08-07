package in.SpringBot.LaptopApplication.Repository;

//import in.SpringBoot.Filters.Entity.Laptop;
import in.SpringBot.LaptopApplication.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository  extends JpaRepository<Laptop, Long> {
}
