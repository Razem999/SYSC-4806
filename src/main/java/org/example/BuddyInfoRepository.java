package org.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long>{

    List<BuddyInfo> findBuddyInfoByName(String name);

    BuddyInfo findBuddyInfoById(Long id);
}
