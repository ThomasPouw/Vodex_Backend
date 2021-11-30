package abibliophobia.vodex.Repository.OptionRepository.RegionAge;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRegionAge extends MongoRepository<RegionAge, String> {
public RegionAge findRegionAgeByID(String ID);
}
