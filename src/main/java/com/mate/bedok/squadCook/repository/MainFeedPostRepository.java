package com.mate.bedok.squadCook.repository;

import com.mate.bedok.squadCook.entities.MainFeedPost;
import com.mate.bedok.squadCook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainFeedPostRepository extends JpaRepository<MainFeedPost, Long> {
    List<MainFeedPost> findAllByIdNotNullOrderByIdDesc();
    MainFeedPost getById(long id);
    MainFeedPost getByPostedByAndPosted(User user, boolean posted);
}
